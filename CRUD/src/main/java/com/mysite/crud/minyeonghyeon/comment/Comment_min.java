package com.mysite.crud.minyeonghyeon.comment;

import java.time.LocalDateTime;

import com.mysite.adminexam.Board;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Comment_min {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	private LocalDateTime createdate;
	
	@ManyToOne
	private Notice_min notice;
}
