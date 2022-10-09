package prac.vuejpa.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer pk;
  private String id;
  private String password;
  private String name;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String grade;
  private int money;
  private String email;
  private Date birth;
  @Column(name = "reg_date")
  // 사실 스프링부트에서는 알아서 카멜케이스 -> 언더스코어로 변환해줌 (그래서 생략가능)
  private Date regDate;
  private int point;

  public Integer getPk() {
    return pk;
  }

  public void setPk(Integer pk) {
    this.pk = pk;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getBirth() {
    return birth;
  }

  public void setBirth(Date birth) {
    this.birth = birth;
  }

  public Date getRegDate() {
    return regDate;
  }

  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (pk != user.pk) return false;
    if (!id.equals(user.id)) return false;
    if (!password.equals(user.password)) return false;
    return name.equals(user.name);
  }

  @Override
  public int hashCode() {
    int result = pk;
    result = 31 * result + id.hashCode();
    result = 31 * result + password.hashCode();
    result = 31 * result + name.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return "User{" +
            "pk=" + pk +
            ", id='" + id + '\'' +
            ", password='" + password + '\'' +
            ", name='" + name + '\'' +
            ", grade='" + grade + '\'' +
            ", money=" + money +
            ", email='" + email + '\'' +
            ", birth=" + birth +
            ", regDate=" + regDate +
            ", point=" + point +
            '}';
  }
}
