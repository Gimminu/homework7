package com.mysite.crud.honghyeonji;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("honghyeonjiMainConroller")
public class MainController {
    @GetMapping("/honghyeonji")
    public String index(){
        return "index";
    }
}
