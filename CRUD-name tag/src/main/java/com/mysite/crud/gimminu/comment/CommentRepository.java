package com.mysite.crud.gimminu.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("gimminuCommentRepository")
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
