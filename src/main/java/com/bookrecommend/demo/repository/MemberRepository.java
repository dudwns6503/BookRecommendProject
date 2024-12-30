package com.bookrecommend.demo.repository;

import com.bookrecommend.demo.domain.Book;
import com.bookrecommend.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
