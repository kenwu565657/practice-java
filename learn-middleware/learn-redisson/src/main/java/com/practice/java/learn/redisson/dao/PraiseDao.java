package com.practice.java.learn.redisson.dao;

import com.practice.java.learn.redisson.entity.PraiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PraiseDao extends JpaRepository<PraiseEntity, String> {
    PraiseEntity getByBlogIdAndUserId(String blogId, String userId);
}
