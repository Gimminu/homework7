package com.mysite.crud;

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

@Data
@Entity
public class Notice {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@Column(length = 200)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime date;
	
	@OneToMany(mappedBy="notice",cascade = CascadeType.REMOVE)
	private List<Reply>ReplyList;
}
