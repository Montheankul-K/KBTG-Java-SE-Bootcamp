package com.example.javacourse.news;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @GetMapping(value = "/latest")
    // if not send X-API-VERSION in header use this version
    public News latestNews() {
        return new News("Title Day-1", "Body");
    }

    @GetMapping(value = "/latest", headers = "X-API-VERSION=2")
    public NewsV2 latestNewsV2() {
        return new NewsV2("Title Day-1", "Body");
    }
}

record News(String title, String body) {}
record NewsV2(String title, String content) {}
