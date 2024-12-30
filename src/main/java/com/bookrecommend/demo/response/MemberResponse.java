package com.bookrecommend.demo.response;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {

    private String login;
    private String nickName;
    private String email;
    private String role;

    public static MemberResponse from(Member member) {
        return MemberResponse.builder()
                .login(member.getLogin())
                .nickName(member.getNickName())
                .email(member.getEmail())
                .role(member.getRole())
                .build();
    }
}
