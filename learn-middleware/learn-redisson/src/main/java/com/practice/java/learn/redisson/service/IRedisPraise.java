package com.practice.java.learn.redisson.service;

import com.practice.java.learn.redisson.dto.PraiseRankDto;

import java.util.List;

public interface IRedisPraise {
    void cachePraiseBlog(Integer blogId, Integer userId, Integer status) throws Exception ;
    Long getCacheTotalBlog(Integer blogId);
    void rankBlogPraise();
    List<PraiseRankDto> getBlogPraiseRank();
}
