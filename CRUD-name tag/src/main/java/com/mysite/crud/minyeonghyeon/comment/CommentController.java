package com.mysite.crud.minyeonghyeon.comment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.crud.minyeonghyeon.notice.Notice;
import com.mysite.crud.minyeonghyeon.notice.NoticeService;

import lombok.RequiredArgsConstructor;



@RequestMapping("/minyeonghyeon/comment")
@RequiredArgsConstructor
@Controller("minyeonghyeonCommentController")
public class CommentController {
	private final NoticeService noticeService;
	private final CommentService commentService;
	
	@PostMapping("/create/{id}")
	public String createAnswer(Model model,
								@PathVariable("id") Integer id,
								@RequestParam(value="content")String content) {
		Notice notice = this.noticeService.getNotice(id);
		commentService.create(notice, content);
		return String.format("redirect:/minyeonghyeon/notice/detail/%s", id);
//		return "redirect:/question/detail/"+ id;
	}
}
