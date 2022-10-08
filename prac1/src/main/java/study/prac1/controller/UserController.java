package study.prac1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import study.prac1.domain.User;
import study.prac1.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/register")
    public String userRegisterForm(){
        return "register";
    }
    @PostMapping("/user/register")
    public String userRegister(@ModelAttribute User user){
        userService.userRegister(user);
        return "redirect:/";
    }

    @GetMapping("/user/login")
    public String userLoginForm(){
        return "login";
    }
    @PostMapping("/user/login")
    public String userLogin(@ModelAttribute User user,
                            HttpServletRequest request,
                            HttpServletResponse response){
        if(userService.userLogin(user)){
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("pwd", user.getPwd());
            session.setAttribute("name", user.getName());

            System.out.println("##########################");
            System.out.println(user.toString());
            System.out.println("user.getName() = " + user.getName());
            System.out.println("session.getAttribute(\"name\") = " + session.getAttribute("name"));
            System.out.println("##########################");

        }
        return "redirect:/";
    }
}
