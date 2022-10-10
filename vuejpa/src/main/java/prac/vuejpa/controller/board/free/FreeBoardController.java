package prac.vuejpa.controller.board.free;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import prac.vuejpa.domain.Article;
import prac.vuejpa.domain.Pagination;
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
  public String getArticleListController(int nowPage, int articleCount){

    System.out.println("freeBoardService.getTotalArticleCount() = " + freeBoardService.getTotalArticleCount());
    Pagination pagination = new Pagination(
            freeBoardService.getTotalArticleCount(),
            nowPage,articleCount,10);

    String listJson = freeBoardService.getArticleListService(pagination, articleCount);


    return listJson;
//    return new String[] {"바보","메롱"};
  }

  @GetMapping("/board/free/pagination")
  public String getArticlePaginationController(int nowPage, int articleCount){

//    System.out.println("freeBoardService.getTotalArticleCount() = " + freeBoardService.getTotalArticleCount());
    Pagination pagination = new Pagination(
            freeBoardService.getTotalArticleCount(),
            nowPage,articleCount,10);

    String paginationJson = new Gson().toJson(pagination);

    System.out.println("#####################################################");
    System.out.println("pagination.toString() = " + pagination.toString());
    System.out.println("#####################################################");


    return paginationJson;
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
