package com.practice.java.learn.redisson.service;

import com.practice.java.learn.redisson.dto.PraiseDto;
import com.practice.java.learn.redisson.dto.PraiseRankDto;

import java.util.Collection;

public interface IPraiseService {
    void addPraise(PraiseDto praiseDto);
    void cancelPraise(PraiseDto praiseDto) throws Exception;
    Long getPraiseCount(Integer blogId);
    Collection<PraiseRankDto> getPraiseRank();
}
