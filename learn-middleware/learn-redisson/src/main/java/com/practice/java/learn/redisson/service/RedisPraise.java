package com.practice.java.learn.redisson.service;

import com.practice.java.learn.redisson.dto.PraiseRankDto;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisPraise implements IRedisPraise {
    private static final String keyBlog = "RedisBlogPraiseMap";
    private static final String praiseLockName = "blogRedissonPraiseLock";
    private final RedissonClient redissonClient;

    @Override
    public void cachePraiseBlog(Integer blogId, Integer userId, Integer status) throws Exception {
        final String lockName = praiseLockName + blogId + userId + status;
        RLock rLock = redissonClient.getLock(lockName);
        boolean locked = rLock.tryLock(100, 10, TimeUnit.SECONDS);
        try {
            if (locked) {
                final String key = blogId+":"+userId;
                RMap<String, Integer> praiseMap = redissonClient.getMap(keyBlog);
                if (1 == status) {
                    praiseMap.putIfAbsent(key, userId);
                } else {
                    praiseMap.remove(key);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            rLock.unlock();
        }
    }

    @Override
    public Long getCacheTotalBlog(Integer blogId) {
        long result = 0L;
        RMap<String, Integer> praiseMap = redissonClient.getMap(keyBlog);
        Map<String, Integer> dataMap = praiseMap.readAllMap();
        Set<String> keySet = dataMap.keySet();
        int bId;
        for (String key : keySet) {
            String[] splitedKey = key.split(":");
            bId = Integer.parseInt(splitedKey[0]);
            if (blogId.equals(bId)) {
                result = result+1;
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rankBlogPraise() {
        final String key = "praiseRankListKey";
        RList<PraiseRankDto> praiseRankList = redissonClient.getList(key);
        praiseRankList.clear();
    }

    @Override
    public List<PraiseRankDto> getBlogPraiseRank() {
        final String key = "praiseRankListKey";
        RList<PraiseRankDto> praiseRankList = redissonClient.getList(key);
        return praiseRankList.readAll();
    }
}
