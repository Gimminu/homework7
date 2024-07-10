package com.mysite.crud.minyeonghyeon.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/min/Notice")
@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/board")
	public String readlist(Model model) {
		model.addAttribute("Notices", noticeService.readlist());
		return "notice_board";
	}
	
	@GetMapping("/create")
	public String create() {
		return "notice_create";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Notice notice) {
		
		noticeService.create(notice);
		return "redirect:/Notice/board";
	}
	
	@GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("Notice", noticeService.getNotice(id));
        return "notice_detail";
    }
	
	@GetMapping("/delete/{id}")
	public String delete( @PathVariable("id") Integer id) {
		noticeService.delete(id);
		return "redirect:/Notice/board";
	}
	
	@GetMapping("/update/{id}")
	public String update(Model model, @PathVariable ("id") Integer id) {
		
		model.addAttribute("Notice", noticeService.getNotice(id));

		return "notice_update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Notice notice) {
		
		noticeService.update(notice);
		return "redirect:/Notice/board";
	}
}
