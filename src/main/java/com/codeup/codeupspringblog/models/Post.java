package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "blog_posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 2000)
    private String body;

    @ManyToOne
    @ToString.Exclude
//    ^this will allow us to avoid infinite recursion because the ToString lombok methods continuously call one another
    @JoinColumn(name = "user_id")
    private User user;
}
