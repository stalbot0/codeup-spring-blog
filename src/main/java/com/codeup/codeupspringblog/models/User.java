package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blog_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    @ToString.Exclude
//    ^this will allow us to avoid infinite recursion because the ToString lombok methods continuously call one another
    private List<Post> posts;
}
