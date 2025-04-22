package com.practice.java.learn.redisson.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class PraiseRankDto {
    private Integer blogId;
    private Long total;
}
