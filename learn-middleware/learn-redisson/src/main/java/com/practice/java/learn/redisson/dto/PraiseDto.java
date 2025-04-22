package com.practice.java.learn.redisson.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PraiseDto implements Serializable {
    private Integer blogId;
    private Integer userId;
}
