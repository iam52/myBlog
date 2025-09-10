package me.project.simpleBlog.controller;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.Article;
import me.project.simpleBlog.dto.AddArticleRequest;
import me.project.simpleBlog.dto.ArticleResponse;
import me.project.simpleBlog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class BlogApiController {

    private final BlogService blogService;

    @PostMapping("/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest addArticleRequest) {
        Article savedArticle = blogService.save(addArticleRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> findArticle(@PathVariable long id) {
        Article article = blogService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(article);
    }
}
