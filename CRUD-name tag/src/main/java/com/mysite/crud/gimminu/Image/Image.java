package com.mysite.crud.gimminu.Image;

import com.mysite.crud.gimminu.notice.Notice;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name="gimminuImage")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String filekey;
    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;
}
