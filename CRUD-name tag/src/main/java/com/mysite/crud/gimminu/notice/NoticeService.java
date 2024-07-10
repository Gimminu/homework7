package com.mysite.crud.gimminu.notice;

import com.mysite.crud.gimminu.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("gimminuNoticeSerivce")
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public void create(Notice notice){
        notice.setDate(LocalDateTime.now());
        noticeRepository.save(notice);
    }
    public List<Notice> getList(){
        return noticeRepository.findAll();
    }
    public Notice getNotice(int id) {
        Optional<Notice> notice = noticeRepository.findById(id);
        if(notice.isPresent()){
            return notice.get();
        }else {
            throw new DataNotFoundException("Notice not found");
        }
    }
    public void deleteById(Integer id){
        noticeRepository.deleteById(id);
    }
    public void update(Notice notice){
        noticeRepository.save(notice);
    }
}
