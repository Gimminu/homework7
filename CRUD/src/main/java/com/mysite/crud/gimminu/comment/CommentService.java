package com.mysite.crud.gimminu.comment;

import com.mysite.crud.gimminu.notice.Notice;
import com.mysite.crud.gimminu.notice.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;


@RequiredArgsConstructor@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final NoticeService noticeService; // NoticeService를 주입받습니다.

    public void createComment(Integer noticeId, String content) {
        Comment newComment = new Comment();
        newComment.setContent(content);

        // Notice 객체를 가져오는 로직
        Notice notice = noticeService.getNotice(noticeId); // getNotice 메소드가 NoticeService에 정의되어 있어야 합니다.
        if (notice == null) {
            throw new IllegalStateException("The notice with ID " + noticeId + " does not exist.");
        }

        newComment.setNotice(notice);
        newComment.setDate(LocalDateTime.now());
        commentRepository.save(newComment);
    }
}
