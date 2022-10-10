package prac.vuejpa.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import prac.vuejpa.domain.Article;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
@Transactional
@RequiredArgsConstructor
public class BoardRepository {
  private final EntityManager em;


  public void save(Article article) {
    em.persist(article);
  }

  public List<Article> findAll() {
    String jpql = "select i from Article i";

    return em.createQuery(jpql, Article.class)
            .getResultList();
  }

  public List<Article> findRange(int firstIndex, int articleCount) {
    String jpql = "select i from Article i";

    TypedQuery<Article> query = em.createQuery(jpql, Article.class);
    query.setFirstResult(firstIndex);
    query.setMaxResults(articleCount);

    return query.getResultList();
  }

  public Article findById(String id){
    return em.find(Article.class,id);
  }

  public Article findByPk(int pk){
    return em.find(Article.class,pk);
  }

  public void update(int articlePk, Article updateArticle) {
    Article findArticle = em.find(Article.class, articlePk);
    findArticle.setPk(updateArticle.getPk());
    findArticle.setTitle(updateArticle.getTitle());
    findArticle.setContent(updateArticle.getContent());
    findArticle.setWriter(updateArticle.getWriter());
    findArticle.setWriteDate(updateArticle.getWriteDate());
    findArticle.setViewCount(updateArticle.getViewCount());
  }

  public void deleteByPk(int pk) {
    Article article = findByPk(pk);
    em.remove(article);
  }
}
