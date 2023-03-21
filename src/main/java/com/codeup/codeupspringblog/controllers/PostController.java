package com.codeup.codeupspringblog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class PostController {

    @GetMapping("/posts")
    public String postsIndex() {
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewIndividualPost(@PathVariable long id) {
        return String.format("posts/%d", id);
    }

    @GetMapping("/posts/create")
    public String GETcreatePost() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String POSTcreatePost() {
        return "posts/create";
    }

}
