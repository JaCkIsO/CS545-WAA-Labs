package edu.miu.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "TITLE")
    String title;
    @Column(name = "CONTENT")
    String content;
    @Column(name = "AUTHOR")
    String author;
}
