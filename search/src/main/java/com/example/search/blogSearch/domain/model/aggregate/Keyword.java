package com.example.search.blogSearch.domain.model.aggregate;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@AllArgsConstructor
@Builder
@Table(name = "KEYWORD")
public class Keyword {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "keyword")
  private String keyword;

  @Column(name = "count")
  private Integer count;

  @Column(name = "reg_dtm", nullable = false)
  private LocalDateTime regDate;

  @Column(name = "edit_dtm")
  private LocalDateTime changeDate;


  //count 횟수 1증가
  public void addCount() {
    this.count = count + 1;
    this.changeDate = LocalDateTime.now();
  }

}
