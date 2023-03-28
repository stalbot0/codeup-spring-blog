package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
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
        User testUser = usersDao.findById(1L).get();
        post.setUser(testUser);
        postsDao.save(post);

        return "redirect:/posts";
    }

    @GetMapping
    public String allPosts(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/{postId}")
    public String viewOnePost(@PathVariable long postId, Model model) {
        Post testPost = postsDao.findById(postId).get();
        model.addAttribute("post", testPost);

        return "posts/show";
    }
}
