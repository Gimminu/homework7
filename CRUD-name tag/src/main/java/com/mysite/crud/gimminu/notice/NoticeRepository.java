package com.mysite.crud.gimminu.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("gimminuNoticeRepository")
public interface NoticeRepository extends JpaRepository<Notice, Integer> {
}
