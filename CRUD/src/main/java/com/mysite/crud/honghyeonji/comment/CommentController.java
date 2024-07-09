package com.mysite.crud.honghyeonji.comment;

import com.mysite.crud.honghyeonji.notice.Notice;
import com.mysite.crud.honghyeonji.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/comment")
@Controller
@RequiredArgsConstructor
public class CommentController {
    private final NoticeService noticeService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String comment){
        Notice notice = this.noticeService.readdetail(id);
        this.commentService.create(notice, comment);
        return String.format("redirect:/notice/readdetail/%s", id);
    }
}
