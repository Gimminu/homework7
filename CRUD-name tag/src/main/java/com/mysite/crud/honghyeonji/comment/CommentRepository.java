package com.mysite.crud.honghyeonji.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("honghyeonjiReposioty")
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
