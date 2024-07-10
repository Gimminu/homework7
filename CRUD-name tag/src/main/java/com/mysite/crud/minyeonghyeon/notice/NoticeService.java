package com.mysite.crud.minyeonghyeon.notice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.crud.S3Service;
import com.mysite.crud.gimminu.DataNotFoundException;

@Service("min-yeonghyeonNoticeService")
public class NoticeService {
	@Autowired
	private NoticeRepository noticeRepository;
	
	@Autowired
	private S3Service s3Service;
	
	public void create(Notice notice,MultipartFile file1,MultipartFile file2, MultipartFile file3) throws IOException {
//		Notice notice = new Notice();
//		notice.setTitle(title);
//		notice.setContent(content);
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		UUID uuid3 = UUID.randomUUID();
		String fileName1 = uuid1 + "_" + file1.getOriginalFilename();
		String fileName2 = uuid2 + "_" + file2.getOriginalFilename();
		String fileName3 = uuid3 + "_" + file3.getOriginalFilename();
		s3Service.UploadFile(file1, fileName1);
		s3Service.UploadFile(file2, fileName2);
		s3Service.UploadFile(file3, fileName3);
		notice.setImage1(fileName1);
		notice.setImage2(fileName2);
		notice.setImage3(fileName3);
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
