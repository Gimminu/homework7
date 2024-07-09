package com.mysite.crud.gimminu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/gimminu")
@Controller
@RequiredArgsConstructor
public class MainController {
    @GetMapping("/gimminuindex")
    public String gimminuIndex() {
        return "gimminu/gimminuindex";
    }
}
