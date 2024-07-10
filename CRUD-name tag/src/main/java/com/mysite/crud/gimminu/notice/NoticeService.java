package com.mysite.crud.gimminu.notice;

import com.mysite.crud.S3Service;
import com.mysite.crud.gimminu.DataNotFoundException;
import com.mysite.crud.gimminu.Image.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("gimminuNoticeSerivce")
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final S3Service s3Service;


    public void create(Notice notice, List<MultipartFile> files) throws IOException {
        if (files!= null && !files.isEmpty()) {
            List<Image> images = new ArrayList<>();
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileKey = s3Service.uploadmanyFiles(file);
                    Image image = new Image();
                    image.setFilekey(fileKey);
                    image.setNotice(notice);
                    images.add(image);
                }
            }
            if (!images.isEmpty()) {
                if(notice.getImages() == null){
                    notice.setImages(images);
                }else {
                    notice.getImages().addAll(images);
                }
            }
        }
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
