package study.prac1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.prac1.domain.User;
import study.prac1.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void userRegister(User user){
        userRepository.userRegister(user);
    }

    public boolean userLogin(User user) {
        User userInfo = userRepository.userLogin(user);
        return loginCheck(user, userInfo);
    }

    public boolean loginCheck(User user1, User user2){
        return user1.getId().equals(user2.getId()) &&
                user1.getPwd().equals(user2.getPwd());
    }
}
