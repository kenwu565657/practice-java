package com.practice.java.learn.redis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "red_pocket_detail")
public class RedPocketDetailEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "record_id")
    private Integer recordId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "is_active")
    private Byte isActive;

    @Column(name = "create_time")
    private Date createTime;
}
