package me.project.simpleBlog.service;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.Article;
import me.project.simpleBlog.dto.AddArticleRequest;
import me.project.simpleBlog.dto.UpdateArticleRequest;
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

    public void delete(long id) {
        blogRepository.deleteById(id);
    }

    public Article update(long id, UpdateArticleRequest updateArticleRequest) {
        Article article = blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found" + id));
        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());
        return article;
    }
}
