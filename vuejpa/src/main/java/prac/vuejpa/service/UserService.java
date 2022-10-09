package prac.vuejpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import prac.vuejpa.domain.User;
import prac.vuejpa.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User userSignupService(User user){
    return userRepository.save(user);
  }

  public User userFindByPkService(int pk){
    return userRepository.findByPk(pk);
  }

  public User userFindByIdService(String id){
    return userRepository.findById(id);
  }

  public void userInfoModifyService(int userPk, User updateUser){
    userRepository.update(userPk, updateUser);
  }
}
