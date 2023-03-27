package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    private final PostRepository postsDao;

    public PostController(PostRepository postsDao) {
        this.postsDao = postsDao;
    }

//    @GetMapping
//    public String postsIndex() {
//        return "posts/index";
//    }

//    @GetMapping("/{id}")
//    public String viewIndividualPost(@PathVariable long id) {
//        return String.format("posts/%d", id);
//    }

    @GetMapping("/create")
    public String GETcreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String POSTcreatePost(@ModelAttribute("post") Post post) {
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping
    public String allPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
//        List<Post> allPosts = postsDao.findAll();
//        System.out.println(allPosts);
        return "posts/index";
    }

    @GetMapping("/{postId}")
    public String viewOnePost(@PathVariable long postId, Model model) {
        model.addAttribute("post", new Post(postId, "titlenewpost", "bodynewpost"));
        return "posts/show";
    }
}
