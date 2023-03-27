package com.codeup.codeupspringblog.controllers;

import models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
@ResponseBody
public class PostController {

    @GetMapping
    public String postsIndex() {
        return "posts/index";
    }

    @GetMapping("/{id}")
    public String viewIndividualPost(@PathVariable long id) {
        return String.format("posts/%d", id);
    }

    @GetMapping("/create")
    public String GETcreatePost() {
        return "posts/create";
    }

    @PostMapping("/create")
    public String POSTcreatePost() {
        return "posts/create";
    }

    @GetMapping
    public String allPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1, "title1", "body1"));
        posts.add(new Post(2, "title2", "body2"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/{postId}")
    public String viewOnePost(@PathVariable long postId) {
        return "hello";
    }
}
