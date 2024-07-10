package com.mysite.crud.gimminu.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/gimminu/comment")
@RequiredArgsConstructor
@Controller("CommentController")
public class CommentController {

    private final CommentService commentService;
    @PostMapping("/create/{noticeId}")
    public String createComment(@PathVariable("noticeId") Integer noticeId, @RequestParam("content") String content) {
        commentService.createComment(noticeId,content);
        return String.format("redirect:/gimminu/notice/notice_detail/%s", noticeId);
    }
}