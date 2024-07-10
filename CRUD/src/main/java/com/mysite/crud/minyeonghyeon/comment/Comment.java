package com.mysite.crud.minyeonghyeon.comment;

import java.time.LocalDateTime;

import com.mysite.crud.minyeonghyeon.notice.Notice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;

	 @Column(columnDefinition = "TEXT")
	 private String content;

	 private LocalDateTime createDate; 
	 
	 @ManyToOne
	 private Notice notice;
}
