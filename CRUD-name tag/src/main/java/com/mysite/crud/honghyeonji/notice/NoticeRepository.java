package com.mysite.crud.honghyeonji.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("honghyeonjiNoticeRepository")
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

}
