package prac.vuejpa.controller.board.free;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import prac.vuejpa.domain.Article;
import prac.vuejpa.domain.User;
import prac.vuejpa.service.board.free.FreeBoardService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FreeBoardController {
  private final FreeBoardService freeBoardService;
  /**
   * Free Board 의 게시글 목록 조회
   */
  @GetMapping("/board/free/article")
  public String getArticleListController(int firstIndex, int articleCount){
    String listJson = freeBoardService.getArticleListService(firstIndex, articleCount);





    System.out.println("listJson = " + listJson);
    return listJson;
  }

  @PostMapping("/board/free/article")
  public void writeArticleController(@RequestBody Article article){
    freeBoardService.writeArticleService(article);
  }

  @GetMapping("/board/free/article/{pk}")
  public void readArticleController(@PathVariable int pk){
    freeBoardService.readArticleService(pk);
  }

  @DeleteMapping("/board/free/article/{pk}")
  public void deleteArticleController(@PathVariable int pk){
    freeBoardService.deleteArticleService(pk);
  }

  /**
   * free board 글 수정
   * */
  @PutMapping("/board/free/article")
  public void modifyArticleController(@RequestBody Article article){
    System.out.println(article.toString());
    freeBoardService.modifyArticleService(article);

  }
}
