package com.bookrecommend.demo.controller;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
import com.bookrecommend.demo.repository.MemberRepository;
import com.bookrecommend.demo.response.BookResponse;
import com.bookrecommend.demo.response.CommonResponse;
import com.bookrecommend.demo.response.MemberResponse;
import com.bookrecommend.demo.service.BookService;
import com.bookrecommend.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<CommonResponse<MemberRepository>> createMember() {
        // 받은 데이터를 검증 후 엔티티로 변환하거나 DTO를 통해 Service 계층으로 넘겨주는 것이 일반적이다.
//        Member member = Member.builder()
//                .title("채식주의자")
//                .author("한강")
//                .price(20000)
//                .thumbnailImage("https://imageUrl")
//                .isbn("123123213")
//                .build();
//
//        memberService.save(member);

        return ResponseEntity.ok(CommonResponse.success());
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<CommonResponse<MemberResponse>> findMember(@PathVariable("id") Long id) {
        Member member = memberService.findMember(id);

        MemberResponse response = MemberResponse.from(member);

        return ResponseEntity.ok(CommonResponse.success(response));
    }
}
