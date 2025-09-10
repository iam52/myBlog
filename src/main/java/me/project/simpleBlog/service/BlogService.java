package me.project.simpleBlog.service;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.Article;
import me.project.simpleBlog.dto.AddArticleRequest;
import me.project.simpleBlog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }
}
