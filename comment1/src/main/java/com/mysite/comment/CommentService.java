package com.mysite.comment;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void create(Comment comment) {
        comment.setDate(LocalDateTime.now());
        this.commentRepository.save(comment);
    }

    public List<Comment> readlist() {
        return commentRepository.findAll();
    }
}
    