package com.practice.java.learn.redis.dao;

import com.practice.java.learn.redis.entity.RedPocketDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPocketDetailDao extends JpaRepository<RedPocketDetailEntity, Integer> {
}
