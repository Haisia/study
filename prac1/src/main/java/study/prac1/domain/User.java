package study.prac1.domain;

import java.util.Date;
import java.util.Objects;

public class User {
    private Integer uid;
    private String id;
    private String pwd;
    private String name;
    private Date regDate;
    private int point;
    private int grade;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (uid != user.uid) return false;
        if (point != user.point) return false;
        if (grade != user.grade) return false;
        if (!id.equals(user.id)) return false;
        if (!pwd.equals(user.pwd)) return false;
        if (!Objects.equals(name, user.name)) return false;
        return Objects.equals(regDate, user.regDate);
    }

    @Override
    public int hashCode() {
        int result = uid;
        result = 31 * result + id.hashCode();
        result = 31 * result + pwd.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (regDate != null ? regDate.hashCode() : 0);
        result = 31 * result + point;
        result = 31 * result + grade;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", regDate=" + regDate +
                ", point=" + point +
                ", grade=" + grade +
                '}';
    }
}
