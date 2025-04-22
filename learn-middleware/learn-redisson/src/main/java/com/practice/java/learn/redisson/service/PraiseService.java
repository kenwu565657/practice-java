package com.practice.java.learn.redisson.service;

import com.practice.java.learn.redisson.dao.PraiseDao;
import com.practice.java.learn.redisson.dto.PraiseDto;
import com.practice.java.learn.redisson.dto.PraiseRankDto;
import com.practice.java.learn.redisson.entity.PraiseEntity;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class PraiseService implements IPraiseService {
    private static final String keyAddBlogLock = "RedisBlogPraiseAddLock";

    private final RedissonClient redissonClient;
    private final PraiseDao praiseDao;
    private final IRedisPraise redisPraise;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addPraise(PraiseDto praiseDto) {
        final String lockName = keyAddBlogLock + praiseDto.getBlogId() + "-" + praiseDto.getUserId();
        RLock lock = redissonClient.getLock(lockName);
        lock.lock(10L, TimeUnit.SECONDS);

        try {
            PraiseEntity praiseEntity = praiseDao.getByBlogIdAndUserId(praiseDto.getBlogId().toString(), praiseDto.getUserId().toString());
            if (null == praiseEntity) {
                praiseEntity = new PraiseEntity();
                Date praiseDate = new Date();
                praiseEntity.setCreateTime(praiseDate);
                praiseEntity.setStatus(1);
                var savedPraiseEntity = praiseDao.save(praiseEntity);
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void cancelPraise(PraiseDto praiseDto) throws Exception {
        PraiseEntity praiseEntity = praiseDao.getByBlogIdAndUserId(praiseDto.getBlogId().toString(), praiseDto.getUserId().toString());
        praiseEntity.setStatus(0);
        praiseEntity.setUpdateTime(new Date());
        praiseDao.save(praiseEntity);
        redisPraise.cachePraiseBlog(praiseDto.getBlogId(), praiseDto.getUserId(), 0);
    }

    @Override
    public Long getPraiseCount(Integer blogId) {
        return redisPraise.getCacheTotalBlog(blogId);
    }

    @Override
    public Collection<PraiseRankDto> getPraiseRank() {
        return List.of();
    }
}
