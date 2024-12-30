package com.bookrecommend.demo.service;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
import com.bookrecommend.demo.exception.BookNotFoundException;
import com.bookrecommend.demo.exception.MemberNotFoundException;
import com.bookrecommend.demo.repository.BookRepository;
import com.bookrecommend.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public void save(Member member) {
        Member savedMember = memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member findMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new MemberNotFoundException());

        return member;
    }
}
