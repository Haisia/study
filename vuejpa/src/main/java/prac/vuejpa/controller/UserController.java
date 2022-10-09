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
  public Boolean userSignupController(@RequestBody User user) {
    if (user.getGrade().equals("") || user.getPk() == 0) {
      user.setGrade("Silver");
      user.setPk(null);
    }
    return userService.userSignupService(user) != null;
  }

  @PostMapping("/user/login")
  public String userLoginController(@RequestBody User user) {
    System.out.println(user.toString());
    return null;
  }
}
