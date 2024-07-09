package com.mysite.crud.minyeonghyeon.notice;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Notice_min {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200)
	private String title;
	
	@Column(columnDefinition="TEXT")
	private String content;
	
	private LocalDateTime createdate;
	
	@OneToMany(mappedBy="notice", cascade = CascadeType.REMOVE)
	private List<Comment> commentlist;

}
