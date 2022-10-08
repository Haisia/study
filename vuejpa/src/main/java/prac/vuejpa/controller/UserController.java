package prac.vuejpa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import prac.vuejpa.domain.User;
import prac.vuejpa.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @PostMapping("/user/signup")
  public String userSignupController(@RequestBody User user) throws JsonProcessingException {
    System.out.println(user.toString());

    return "가입완료";
  }

  @PostMapping("/user/login")
  public String userLoginController(){
    return null;
  }

}
