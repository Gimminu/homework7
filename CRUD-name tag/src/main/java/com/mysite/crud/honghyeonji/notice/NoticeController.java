package com.mysite.crud.honghyeonji.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/notice")
@Controller("honghyeonjiNoticeController")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;


    @GetMapping("/readlist")
    public String readlist(Model model){
        model.addAttribute("notices", noticeService.readlist());
        return "honghyeonji/readlist";
    }

    @GetMapping("/create")
    public String creat(){
        return "honghyeonji/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Notice notice){
        noticeService.create(notice);
        return "redirect:/notice/readlist";

    }

    @GetMapping("/readdetail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        model.addAttribute("notice", noticeService.readdetail(id));
        return "honghyeonji/readdetail";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        noticeService.delete(id);
        return "redirect:/notice/readlist";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") Integer id){
        model.addAttribute("notice", noticeService.readdetail(id));
        return "honghyeonji/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Notice notice){
        noticeService.update(notice);
        return "redirect:/notice/readlist";
    }

}
