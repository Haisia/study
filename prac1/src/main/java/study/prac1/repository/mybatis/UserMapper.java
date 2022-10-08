package study.prac1.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;
import study.prac1.domain.User;

@Mapper
public interface UserMapper {
    void insertUser(User user);
    User selectUserById(String id);

}
