package com.hyunjin.study.springboot.web;

import com.hyunjin.study.springboot.config.auth.LoginUser;
import com.hyunjin.study.springboot.config.auth.dto.SessionUser;
import com.hyunjin.study.springboot.services.posts.PostsService;
import com.hyunjin.study.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc()); // 서버 템플릿 안에서 사용할 수 있는 객체를 저장.
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index"; // 앞의 경로와 파일 확장자를 자동으로 지정해줌. 앞의 경로는 src/main/resources/templates. 확장자는 .mustache가 붙는다.
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
