package com.practice.java.learn.redis.dao;

import com.practice.java.learn.redis.entity.RedPocketRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPocketRecordDao extends JpaRepository<RedPocketRecordEntity, Integer> {
}
