package com.practice.java.learn.redis.service;

import com.practice.java.learn.redis.dto.RedPacketDto;
import com.practice.java.learn.redis.utils.RedPacketUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RedPacketService implements IRedPacketService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedPacketService.class);
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public String handOut(RedPacketDto redPacketDto) {
        List<Integer> amountList = RedPacketUtils.divideRedPacket(redPacketDto.getAmount(), redPacketDto.getRedPacketNumber());
        String timestamp = String.valueOf(System.nanoTime());
        String redPocketKey = redPacketDto.getUserId() + ":" + timestamp;
        redisTemplate.opsForList().leftPushAll(redPocketKey, amountList);

        String redPocketTotalKey = redPocketKey + ":" + "total";
        redisTemplate.opsForValue().set(redPocketTotalKey, redPacketDto.getRedPacketNumber());
        return redPocketTotalKey;
    }

    @Override
    public BigDecimal getRedPacket(Integer userId, String redPacketId) {
        return null;
    }
}
