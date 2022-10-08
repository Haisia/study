package prac.vuejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prac.vuejpa.domain.User;
import prac.vuejpa.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public void userSignupService(User user){
    userRepository.userSignupRepository(user);
  }
}
