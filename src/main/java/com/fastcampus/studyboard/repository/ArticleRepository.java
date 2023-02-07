package com.fastcampus.studyboard.repository;

import com.fastcampus.studyboard.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
