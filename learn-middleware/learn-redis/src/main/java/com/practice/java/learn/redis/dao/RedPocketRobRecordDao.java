package com.practice.java.learn.redis.dao;

import com.practice.java.learn.redis.entity.RedPocketRobRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPocketRobRecordDao extends JpaRepository<RedPocketRobRecordEntity, Integer> {
}
