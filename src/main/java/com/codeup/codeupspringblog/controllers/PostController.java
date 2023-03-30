package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/posts")
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
    }

//    @GetMapping
//    public String postsIndex() {
//
//        return "posts/index";
//    }

//    @GetMapping("/{id}")
//    public String viewIndividualPost(@PathVariable long id) {
//
//        return String.format("posts/%d", id);
//    }

    @GetMapping("/create")
    public String GETcreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/create")
    public String POSTcreatePost(@ModelAttribute("post") Post post) {
//        for now, we're hard coding the id until we get into security, so that specific users will be able to create posts associated with their account
        User testUser = usersDao.findById(1L).get();
        post.setUser(testUser);
        postsDao.save(post);

        emailService.prepareAndSend(post, "Hi, this is a third email", "Testing testing 3 hellooooo");
        return "redirect:/posts";
    }

    @GetMapping("/{postId}/edit")
    public String GETeditPost(@PathVariable long postId, Model model) {
        Post post = postsDao.findById(postId).get();
        model.addAttribute("post", post);
//        return "posts/edit";
        return "posts/create";
    }

//    @PostMapping("/{postId}/edit")
//    public String POSTeditPost(@PathVariable long postId, @ModelAttribute("post") Post post) {
//        Post testPost = postsDao.findById(postId).get();
//        testPost.setTitle(post.getTitle());
//        testPost.setBody(post.getBody());
//        postsDao.save(testPost);
//        return "redirect:/posts/" + postId;
//    }

    @GetMapping("/{postId}/delete")
    public String GETdeletePost(@PathVariable long postId, Model model) {
        Post post = postsDao.findById(postId).get();
        model.addAttribute("post", post);
        return "posts/delete";
    }

    @PostMapping("/{postId}/delete")
    public String POSTdeletePost(@PathVariable long postId, @ModelAttribute("post") Post post) {
//        how do I do this using the model attribute for the new post that we have added at the "GET"
        Post testPost = postsDao.findById(postId).get();
        postsDao.deleteById(testPost.getId());
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
