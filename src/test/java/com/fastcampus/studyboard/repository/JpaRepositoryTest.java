package com.fastcampus.studyboard.repository;

import com.fastcampus.studyboard.config.JpaConfig;
import com.fastcampus.studyboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @Test
    void select_테스트() {
        // given

        // when
        List<Article> articles = articleRepository.findAll();

        // then
        assertThat(articles).isNotNull().hasSize(0);
    }

    @Test
    void insert_테스트() {
        // given
        long previousCount = articleRepository.count();

        // when
        Article savedArticle = articleRepository.save(Article.of("new article", "new article content", "hjyu"));

        // then
        assertThat(articleRepository.count()).isEqualTo(previousCount + 1);
    }

    @Test
    void update_테스트() {
        // given
        articleRepository.save(Article.of("new article", "new article content", "hjyu"));
        Article article = articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "updated hashtag";
        article.setHashtag(updatedHashtag);

        // when
        Article savedArticle = articleRepository.saveAndFlush(article);

        // then
        assertThat(savedArticle.getHashtag()).isEqualTo(updatedHashtag);
    }

    @Test
    void delete_테스트() {
        // given
        articleRepository.save(Article.of("new article", "new article content", "hjyu"));
        long previousCount = articleRepository.count();
        Article article = articleRepository.findAll().get(0);

        // when
        articleRepository.delete(article);

        // then
        assertThat(articleRepository.count()).isEqualTo(previousCount - 1);
    }
}