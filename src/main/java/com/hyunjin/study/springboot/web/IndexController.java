package com.hyunjin.study.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // 앞의 경로와 파일 확장자를 자동으로 지정해줌. 앞의 경로는 src/main/resources/templates. 확장자는 .mustache가 붙는다.
    }
}
