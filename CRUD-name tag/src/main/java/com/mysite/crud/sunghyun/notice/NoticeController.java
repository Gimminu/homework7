package com.mysite.crud.sunghyun.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/notice")

@Controller("sunghyunNoticeController")

public class NoticeController {

@Autowired

private NoticeService noticeService;

@GetMapping("/create")

public String create() {

return "create";

}

@PostMapping("/create")

public String create(@ModelAttribute Notice Notice) {

noticeService.create(Notice);

return "redirect:/notice/readlist";

}

@GetMapping("/readlist")

public String readlist(Model model) {

model.addAttribute("notices", noticeService.readlist());

return "readlist";

}
	
@GetMapping("/readdetail/{id}") //readdetail/{id} id값에 맞도록 리드디테일을 불러온다 라고 이해하면 쉬울 듯
public String readdetail(Model model,@PathVariable("id")Integer id) {
	
	model.addAttribute("notice",noticeService.readdetail(id));//주어진 id값에 맞는 상세정보를 model을 통해서 뷰로 나타낸다.
	
	return"readdetail";//readdetail을 리턴
}

@GetMapping("/delete/{id}")//<- 서비스에서 받아오는 거임 오해하지 마삼.
public String delete(@PathVariable("id") Integer id) { //@PathVariable("id") Integer id: 메서드의 매개변수에 @PathVariable 어노테이션을 사용하여, URL 경로에서 {id} 부분을 추출
	noticeService.delete(id);
	return "redirect:/notice/readlist";
}
@GetMapping("/update/{id}") //정보를 가져오고
public String update(Model model, @PathVariable("id")Integer id) {
	model.addAttribute("notice",noticeService.readdetail(id)); //어튜리뷰트 저거는 모델을 사용하기 위한 메서드임  노티스 객체의 정보를 담은 노티스 서비스에서 상세정보의 아이디 값을 가진 값을 가져온다.
	return "update";
}
@PostMapping("/update") //바뀐 정보를 보내고
public String update(@ModelAttribute Notice notice) {
	
	
	noticeService.update(notice);
	
	
	return "redirect:/notice/readlist";
}

}




