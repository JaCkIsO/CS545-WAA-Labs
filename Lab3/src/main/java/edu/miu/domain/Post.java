package edu.miu.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    long id;
    String title;
    String content;
    String author;
}
