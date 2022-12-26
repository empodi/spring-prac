package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 컨트롤러가 JSON을 반환하도록 한다.
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
