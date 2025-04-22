package com.practice.java.learn.redisson.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "praise")
public class PraiseEntity {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "blog_id")
    private String blogId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "praise_time")
    private Date praiseTime;

    @Column(name = "status")
    private Integer status;

    @Column(name = "isActive")
    private Integer isActive;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "updateTime")
    private Date updateTime;
}
