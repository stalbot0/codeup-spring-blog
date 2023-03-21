package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
