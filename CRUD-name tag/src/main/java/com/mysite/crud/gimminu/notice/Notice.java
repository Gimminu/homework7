package com.mysite.crud.gimminu.notice;

import com.mysite.crud.gimminu.comment.Comment;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import java.time.LocalDateTime;

@Entity(name = "gimminuNotice")
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime date;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
