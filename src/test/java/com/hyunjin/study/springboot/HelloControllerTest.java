package com.hyunjin.study.springboot;

import com.hyunjin.study.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // SpringRunner - 스프링 부트 테스트와 JUnit 사이에 연결자 역할
@WebMvcTest(controllers = HelloController.class) // 스프링 MVC에 집중할 수 있는 테스트 어노테이션 - @Controller @ControllerAdvice 등 사용 가능.
public class HelloControllerTest {

    @Autowired // 스프링이 관리하는 빈 주입
    private MockMvc mvc; // 웹 API(GET, POST 등)를 테스트할 때 사용.

    @Test
    public void hello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
