package com.mysite.crud.honghyeonji.notice;

import com.mysite.crud.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("honghyeonjiNoticeService")
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final S3Service s3Service;

    public void create(Notice notice, MultipartFile file1, MultipartFile file2, MultipartFile file3)throws IOException {
        UUID uuid = UUID.randomUUID();
        System.out.println(notice.getTitle());
        System.out.println(notice.getContent());
        if(file1!=null&& !file1.isEmpty()){
            String fileName1 = uuid+"_"+file1.getOriginalFilename();
            s3Service.UploadFile(file1, fileName1);
            notice.setImage1(fileName1);
        }
        else{
            notice.setImage1(null);
        }


        if(file2!=null&& !file2.isEmpty()) {
            uuid = UUID.randomUUID();
            String fileName2 = uuid+"_"+file2.getOriginalFilename();
            s3Service.UploadFile(file2, fileName2);
            notice.setImage2(fileName2);
        }else{
            notice.setImage2(null);

        }

        if(file3!=null&& !file3.isEmpty()) {
            uuid = UUID.randomUUID();
            String fileName3 = uuid+"_"+file3.getOriginalFilename();
            s3Service.UploadFile(file3, fileName3);
            notice.setImage3(fileName3);
        }else{
            notice.setImage3(null);
        }

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
