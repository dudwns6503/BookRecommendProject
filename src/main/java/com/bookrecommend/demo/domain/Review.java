package com.bookrecommend.demo.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Clob;
import java.sql.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @Column(length = 27, unique = true, nullable = false)
    private String review_id;

    @Column(length = 15, nullable = false)
    private String book_id;

    @Column(length = 15, nullable = false)
    private String member_id;

    @Lob
    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column()
    @UpdateTimestamp
    private Date modified_date;

    @Column(length = 2, columnDefinition = "VARCHAR(2) DEFAULT 'N'")
    private String delete_flag;

    @Column(columnDefinition = "INT DEFAULT 0")
    private int heart_cnt;

    @Column(length = 100)
    private String file_url;

    @Column(nullable = false)
    private int rating;

    @Builder
    public Review(String review_id, String book_id, String member_id, String contents, String file_url, int rating) {
        this.review_id = review_id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.contents = contents;
        this.file_url = file_url;
        this.rating = rating;
    }
}

