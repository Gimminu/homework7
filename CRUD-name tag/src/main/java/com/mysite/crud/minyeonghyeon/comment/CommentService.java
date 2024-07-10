package com.mysite.crud.minyeonghyeon.comment;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.mysite.crud.minyeonghyeon.notice.Notice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("min-yeonghyeonCommentService")
public class CommentService {
	private final CommentRepository commentRepository;

	public void create(Notice notice, String content) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setCreateDate(LocalDateTime.now());
		comment.setNotice(notice);
		this.commentRepository.save(comment);
	}
}
