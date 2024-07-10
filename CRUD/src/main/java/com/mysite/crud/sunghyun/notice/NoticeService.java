package com.mysite.crud.sunghyun.notice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public void create(Notice notice) {
        notice.setDate(LocalDateTime.now());
        this.noticeRepository.save(notice);
    }

    public List<Notice> readlist() {
        return noticeRepository.findAll();
    }
    
    public Notice readdetail(Integer id) { //integer id(조회할 상대의 아이디 값을 받아오겠다.
    	Optional<Notice> o = noticeRepository.findById(id); //Optional: Java에서 값이 존재할 수도 있고 없을 수도 있는 상황을 다루는 클래스 id 값에 맞게 노티스의 데이터를 가져온다.
    	return o.get(); //optional에서 얻은 값을 리턴 하겠다.
    }
    
    public void delete(Integer id) {
    	
    	noticeRepository.deleteById(id);
    	
    }
    
    public void update(Notice notice) {
    	noticeRepository.save(notice);
    }
}