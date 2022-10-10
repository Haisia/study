package prac.vuejpa.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@DynamicInsert // null은 넣지 않는다. -> DB 기본값으로 들어간다
public class Article {


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private int pk;
  private String title;
  private String content;
  private String writer;
  @Column(name = "write_date")
  private Date writeDate;
  @Column(name = "view_count")
  private int viewCount;

  @Column(name = "comment_count")
  private int commentCount;

  public int getPk() {
    return pk;
  }

  public void setPk(int pk) {
    this.pk = pk;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public Date getWriteDate() {
    return writeDate;
  }

  public void setWriteDate(Date writeDate) {
    this.writeDate = writeDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public int getCommentCount() {
    return commentCount;
  }

  public void setCommentCount(int commentCount) {
    this.commentCount = commentCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Article article = (Article) o;

    if (pk != article.pk) return false;
    if (!Objects.equals(title, article.title)) return false;
    return Objects.equals(content, article.content);
  }

  @Override
  public int hashCode() {
    int result = pk;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Article{" +
            "pk=" + pk +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", writer='" + writer + '\'' +
            ", writeDate=" + writeDate +
            ", viewCount=" + viewCount +
            ", commentCount=" + commentCount +
            '}';
  }
}
