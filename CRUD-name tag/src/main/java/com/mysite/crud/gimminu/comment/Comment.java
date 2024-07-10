package com.mysite.crud.gimminu.comment;

import com.mysite.crud.gimminu.notice.Notice;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity(name = "gimminuComment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime date;
    @ManyToOne
    private Notice notice;
}
