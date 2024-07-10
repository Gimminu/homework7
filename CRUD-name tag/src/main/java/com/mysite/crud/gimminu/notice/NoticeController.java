package com.mysite.crud.gimminu.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/gimminu/notice")
@RequiredArgsConstructor
@Controller("gimminuNoticeController")
public class NoticeController {
    private final NoticeService noticeService;
    @Value("${cloud.aws.s3.endpoint}")
    private String downpath;
    @GetMapping("/notice_board")
    public String noticeBoard(Model model) {
        List<Notice> noticeList =this.noticeService.getList();
        model.addAttribute("notice_list", noticeList);
        return "/gimminu/notice/notice_board";
    }

    @GetMapping("/notice_create")
    public String noticeCreate() {
        return "/gimminu/notice/notice_create";
    }
    @PostMapping("/notice_create")
    public String noticeCreate(@ModelAttribute Notice notice,
                               @RequestParam("files") List<MultipartFile> files) {
        try {
            noticeService.create(notice, files);
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/gimminu/notice/notice_board";
        }
        return "redirect:/gimminu/notice/notice_board";
    }
    @GetMapping("/notice_detail/{id}")
    public String noticeDetail(@PathVariable int id, Model model) {
        Notice notice =this.noticeService.getNotice(id);
        model.addAttribute("notice",notice);
        model.addAttribute("downpath","https://"+downpath);
        return "gimminu/notice/notice_detail";
    }

    @GetMapping("/notice_update/{id}")
    public String noticeUpdate(@PathVariable int id, Model model) {
        model.addAttribute("notice",noticeService.getNotice(id));
        model.addAttribute("downpath","https://"+downpath);
        return "/gimminu/notice/notice_update";
    }
    @PostMapping("/notice_update")
    public String noticeUpdate(@ModelAttribute Notice notice,
                               @RequestParam("files") List<MultipartFile> files) throws IOException {
        noticeService.update(notice, files);
        return "redirect:/gimminu/notice/notice_detail/" + notice.getId();  // 올바른 리디렉션 경로
    }

    @GetMapping("/notice_delete/{id}")
    public String noticeDelete(@PathVariable int id) {
        noticeService.deleteById(id);
        return "redirect:/gimminu/notice/notice_board";
    }
}
