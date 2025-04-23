package com.practice.java.learn.redis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "red_pocket_record")
public class RedPocketRecordEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "red_packet")
    private String redPacket;

    @Column(name = "total")
    private Integer total;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "is_active")
    private Byte isActive;

    @Column(name = "create_time")
    private Date createTime;
}
