package com.mysite.crud.honghyeonji.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequestMapping("/honghyeonji/notice")
@Controller("honghyeonjiNoticeController")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @Value("${cloud.aws.s3.endpoint}")
    private String downpath;

    @GetMapping("/readlist")
    public String readlist(Model model){
        model.addAttribute("notices", this.noticeService.readlist());
        return "/honghyeonji/readlist";
    }

    @GetMapping("/create")
    public String create(){
        return "/honghyeonji/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Notice notice, @RequestParam("file1")MultipartFile file1,
                         @RequestParam("file2")MultipartFile file2, @RequestParam("file3")MultipartFile file3) throws IOException {
        this.noticeService.create(notice, file1, file2, file3);
        return "redirect:/honghyeonji/notice/readlist";

    }

    @GetMapping("/readdetail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        model.addAttribute("notice", noticeService.readdetail(id));
        model.addAttribute("downpath", "https://"+downpath);
        return "honghyeonji/readdetail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        noticeService.delete(id);
        return "redirect:/honghyeonji/notice/readlist";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("notice", noticeService.readdetail(id));
        return "honghyeonji/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Notice notice){
        this.noticeService.update(notice);
        return "redirect:/honghyeonji/notice/readlist";
    }

}
