package com.mysite.crud.sunghyun.notice;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="sunghyunReply")
public class Reply {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String content;
private LocalDateTime date;
@ManyToOne
private Notice notice;
}

