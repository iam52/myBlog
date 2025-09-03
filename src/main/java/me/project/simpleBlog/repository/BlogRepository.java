package me.project.simpleBlog.repository;

import me.project.simpleBlog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
