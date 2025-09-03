package me.project.simpleBlog.service;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.Article;
import me.project.simpleBlog.dto.AddArticleRequest;
import me.project.simpleBlog.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest addArticleRequest) {
        return blogRepository.save(addArticleRequest.toEntity());
    }
}
