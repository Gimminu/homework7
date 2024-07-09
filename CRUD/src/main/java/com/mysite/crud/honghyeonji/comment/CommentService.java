package com.mysite.crud.honghyeonji.comment;

import com.mysite.crud.honghyeonji.notice.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void create(Notice notice, String content){
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setDate(LocalDateTime.now());
        comment.setNotice(notice);
        this.commentRepository.save(comment);
    }

}
