package com.mysite.crud.minyeonghyeon.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("min-yeonghyeonNoticeRepository")
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
