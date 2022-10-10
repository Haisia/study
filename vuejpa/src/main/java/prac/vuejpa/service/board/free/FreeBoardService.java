package prac.vuejpa.service.board.free;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prac.vuejpa.domain.Article;
import prac.vuejpa.repository.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {
  final private BoardRepository boardRepository;

  public String getArticleListService(int firstIndex, int articleCount) {
    List<Article> articleList = boardRepository.findRange(firstIndex, articleCount);
    String articleListJson = new Gson().toJson(articleList);


    return articleListJson;
  }

  public void writeArticleService(Article article) {
    boardRepository.save(article);
  }

  public void readArticleService(int pk) {
    Article article = boardRepository.findByPk(pk);
    int viewCount=article.getViewCount();
    viewCount++;
    article.setViewCount(viewCount);
    boardRepository.update(pk, article);

  }

  public void deleteArticleService(int pk) {
    boardRepository.deleteByPk(pk);
  }

  public void modifyArticleService(Article article) {
    boardRepository.update(article.getPk(), article);
  }
}
