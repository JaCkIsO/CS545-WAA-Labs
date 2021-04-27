package edu.miu.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column
    String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    List<Post> posts;
}
