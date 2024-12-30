package com.bookrecommend.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.sql.Clob;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
@SQLDelete(sql = "UPDATE review set delete_flag = 'Y' where review_id = ?")
@Where(clause = "delete_flag = 'N'") // https://jaeseo0519.tistory.com/375 SQLRestriction?
public class Review extends BaseEntity {

    @Id
    @Column(length = 27, unique = true, nullable = false, name = "review_id")
    private String reviewId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(length = 15, nullable = false)
    private String memberId;

    @Lob
    @Column(nullable = false)
    private String contents;

    @Column(length = 2, columnDefinition = "VARCHAR(2) DEFAULT 'N'", name = "delete_flag")
    private String deleteFlag;

    @Column(columnDefinition = "INT DEFAULT 0", name = "heart_cnt")
    private int heartCnt;

    @Column(length = 100, name = "file_url")
    private String fileUrl;

    @Column(nullable = false)
    private int rating;

    @Builder
    public Review(String reviewId, Book book, String memberId, String contents, String fileUrl, int rating) {
        this.reviewId = reviewId;
        this.book = book;
        this.memberId = memberId;
        this.contents = contents;
        this.fileUrl = fileUrl;
        this.rating = rating;
    }
}

