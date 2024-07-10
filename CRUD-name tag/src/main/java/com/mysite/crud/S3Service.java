package com.mysite.crud;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class S3Service {
    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;

    private final AmazonS3 amazonS3;

    public void UploadFile(MultipartFile multipartFile, String filename) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        // 현재 서버에 임시 저장
        try (FileOutputStream fos = new FileOutputStream(file)){
            fos.write(multipartFile.getBytes());
        }
        // UUID 적용 버전, UUID가 적용된 파일 이름을 가져와서 사용
        //String filename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();

        // AWS 전송
        amazonS3.putObject(new PutObjectRequest(bucketName, filename, file));
        //임시 저장된 파일 삭제
        file.delete();
    }
    public void DownloadFile(String filename) throws IOException {
        amazonS3.getObject(new GetObjectRequest(bucketName, filename));

    }

}
