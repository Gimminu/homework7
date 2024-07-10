package com.mysite.crud.sunghyun.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("sunghyunNoticeRepository")
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
