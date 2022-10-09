package prac.vuejpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import prac.vuejpa.domain.User;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class UserRepository {
  private final EntityManager em;

  public UserRepository(EntityManager em) {
    this.em = em;
  }

  /**
   * Insert to DataBase
   */
  public User save(User user) {
    em.persist(user);
    return user;
  }

  public User findByPk(int pk) {
    return em.find(User.class, pk);
  }

  public User findById(String id) {
    return em.find(User.class, id);
  }

  public List<User> findAll() {
    String jpql = "select i from User i";

    return em.createQuery(jpql, User.class)
            .getResultList();
  }

  public void update(int userPk, User updateUser) {
    User findUser = em.find(User.class, userPk);
    findUser.setId(updateUser.getId());
    findUser.setPassword(updateUser.getPassword());
    findUser.setName(updateUser.getId());
    findUser.setGrade(updateUser.getGrade());
    findUser.setMoney(updateUser.getMoney());
    findUser.setEmail(updateUser.getEmail());
    findUser.setBirth(updateUser.getBirth());
    findUser.setRegDate(updateUser.getRegDate());
    findUser.setPoint(updateUser.getPoint());

  }
}
