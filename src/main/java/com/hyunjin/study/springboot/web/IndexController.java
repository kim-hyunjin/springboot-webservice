package com.hyunjin.study.springboot.web;

import com.hyunjin.study.springboot.services.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc()); // 서버 템플릿 안에서 사용할 수 있는 객체를 저장.
        return "index"; // 앞의 경로와 파일 확장자를 자동으로 지정해줌. 앞의 경로는 src/main/resources/templates. 확장자는 .mustache가 붙는다.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
