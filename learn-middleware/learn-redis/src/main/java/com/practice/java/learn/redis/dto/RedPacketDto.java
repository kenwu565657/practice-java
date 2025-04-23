package com.practice.java.learn.redis.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RedPacketDto {
    private Integer userId;
    private Integer redPacketNumber;
    private Integer amount;
}
