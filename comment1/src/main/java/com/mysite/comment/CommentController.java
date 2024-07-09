package com.mysite.comment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/comment")

@Controller

public class CommentController {

@Autowired

private CommentService commentService;

@GetMapping("/create")

public String create() {

return "create";

}

@PostMapping("/create")

public String create(@ModelAttribute Comment comment) {

commentService.create(comment);

return "redirect:/comment/readlist";

}

@GetMapping("/readlist")

public String readlist(Model model) {

model.addAttribute("comment", commentService.readlist());

return "readlist";

}
}