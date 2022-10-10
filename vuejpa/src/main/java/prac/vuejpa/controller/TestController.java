package prac.vuejpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import prac.vuejpa.domain.Article;
import prac.vuejpa.domain.Pagination;
import prac.vuejpa.domain.User;
import prac.vuejpa.repository.BoardRepository;
import prac.vuejpa.service.board.free.FreeBoardService;

@RestController
@RequiredArgsConstructor
public class TestController {
  final private FreeBoardService freeBoardService;
  final private BoardRepository boardRepository;

  @GetMapping("/gettest")
  public String getTest(){


    for (int i = 31; i < 100; i++) {
      Article article = new Article();

      String title = "페이징 테스트 중입니다. ";

      article.setTitle(title+i);
      article.setContent("페이징 테스트"+i);
      article.setWriter("haisia");
      article.setViewCount(0);
      article.setCommentCount(0);

      boardRepository.save(article);
    }

    System.out.println("/gettest called");
    return "get";
  }

  @PostMapping("/posttest")
  public String postTest(){
    System.out.println("/posttest called");

    return "post";
  }
}
