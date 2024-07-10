package com.mysite.crud.honghyeonji.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("honghyeonjiNoticeService")
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void create(Notice notice){
        notice.setDate(LocalDateTime.now());
        noticeRepository.save(notice);
    }

    public List<Notice> readlist(){
        return noticeRepository.findAll();
    }

    public Notice readdetail(Integer id){
        Optional<Notice> notice = noticeRepository.findById(id);
        return notice.get();
    }
    public void read(){

    }

    public void update(Notice notice){
        noticeRepository.save(notice);
    }

    public void delete(Integer id){
        noticeRepository.deleteById(id);

    }
}
