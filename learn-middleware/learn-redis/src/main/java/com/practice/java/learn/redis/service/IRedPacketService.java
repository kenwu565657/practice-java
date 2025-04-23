package com.practice.java.learn.redis.service;

import com.practice.java.learn.redis.dto.RedPacketDto;

import java.math.BigDecimal;

public interface IRedPacketService {
    String handOut(RedPacketDto redPacketDto);

    BigDecimal getRedPacket(Integer userId, String redPacketId);
}
