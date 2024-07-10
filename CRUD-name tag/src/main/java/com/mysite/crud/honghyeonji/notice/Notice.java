package com.mysite.crud.honghyeonji.notice;

import com.mysite.crud.honghyeonji.comment.Comment;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="honghyeonjiNotice")
@Data
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime date;

    private String image1;
    private String image2;
    private String image3;

    @OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

}
