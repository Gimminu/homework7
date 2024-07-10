package com.mysite.crud.minyeonghyeon.notice;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/minyeonghyeon/notice")
@Controller("min-yeonghyeonNoticeController")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath; 
	
	@GetMapping("/board")
	public String readlist(Model model) {
		model.addAttribute("Notices", noticeService.readlist());
		return "/minyeonghyeon/notice_board";
	}
	
	@GetMapping("/create")
	public String create() {
		return "/minyeonghyeon/notice_create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Notice notice,
						@RequestParam("file1") MultipartFile file1,
						@RequestParam("file2") MultipartFile file2,
						@RequestParam("file3") MultipartFile file3) throws IOException {
		
		noticeService.create(notice,file1, file2, file3);
		return "redirect:/minyeonghyeon/notice/board";
	}
	
	@GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("notice", noticeService.getNotice(id));
        model.addAttribute("downpath", "https://"+downpath);
        return "minyeonghyeon/notice_detail";
    }
	
	@GetMapping("/delete/{id}")
	public String delete( @PathVariable("id") Integer id) {
		noticeService.delete(id);
		return "redirect:/minyeonghyeon/notice/board";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable ("id") Integer id) {
		
		model.addAttribute("Notice", noticeService.getNotice(id));

		return "/minyeonghyeon/notice_update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Notice notice) {
		
		noticeService.update(notice);
		return "redirect:/minyeonghyeon/Notice/board";
	}
}
