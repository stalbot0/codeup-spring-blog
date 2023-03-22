package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/roll-dice")
public class RollingDiceController {

    @GetMapping
    public String viewDiceRollForm() {
        return "roll-dice";
    }

    @GetMapping("/{n}")
    public String rollNDie(@PathVariable int n, Model model) {
        model.addAttribute("n", n);

        Random x = new Random();
        int randomNum = x.nextInt(1, 7);
        model.addAttribute("randomDie", randomNum);

        return "roll-dice-result";
    }

}
