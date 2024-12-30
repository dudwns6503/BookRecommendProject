package com.bookrecommend.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String login;
    private String password;
    private String nickName;

    private Boolean deleteFlag;
    private String email;
    private LocalDateTime createdAt = super.getCreatedAt(); // baseEntity로 사용
    private LocalDateTime updatedAt = super.getUpdatedAt(); // baseEntity로 사용
    private String role;

    @Builder
    public Member(long id, String login, String password, String nickName, Boolean deleteFlag, String email, LocalDateTime createdAt, LocalDateTime updatedAt, String role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nickName = nickName;
        this.deleteFlag = deleteFlag;
        this.email = email;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.role = role;
    }

}
