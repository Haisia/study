package study.prac1.repository;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.springframework.stereotype.Repository;
import study.prac1.domain.User;
import study.prac1.repository.mybatis.UserMapper;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    final UserMapper userMapper;

    public void userRegister(User user){
        System.out.println("리파지토리 호출됨. \n"+user.toString());
        userMapper.insertUser(user);
    }

    public User userLogin(User user) {
        return userMapper.selectUserById(user.getId());
    }
}
