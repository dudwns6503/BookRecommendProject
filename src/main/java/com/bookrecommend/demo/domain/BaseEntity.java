package com.bookrecommend.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @DateTimeFormat(iso = DATE_TIME)
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime updatedAt;
}
