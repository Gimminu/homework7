package com.mysite.crud.minyeonghyeon.notice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysite.crud.gimminu.DataNotFoundException;

@Service("min-yeonghyeonNoticeService")
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	public void create(Notice notice) {
//		Notice notice = new Notice();
//		notice.setTitle(title);
//		notice.setContent(content);
		notice.setCreatedate(LocalDateTime.now());
		noticeRepository.save(notice);
	}
	public List<Notice> readlist(){
		
		return noticeRepository.findAll();
	}
	
	public Notice getNotice(Integer id) {  
        Optional<Notice> notice = this.noticeRepository.findById(id);
        if (notice.isPresent()) {
            return notice.get();
        } 
            else {
            throw new DataNotFoundException("question not found");
        }
    }
	public void delete(Integer id) {
		
		noticeRepository.deleteById(id);
		
	}
	public void update(Notice notice) {
		
		noticeRepository.save(notice);
		
	}
}
