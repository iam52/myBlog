package me.project.simpleBlog.controller;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.Article;
import me.project.simpleBlog.dto.AddArticleRequest;
import me.project.simpleBlog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        Article savedArticle = blogService.save(addArticleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
