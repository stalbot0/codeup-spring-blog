package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//do all the dice rolling in the controller.
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

        String message = "Wow, you lost!";
        if(n == randomNum) {
            message = "You won. Boo.";
        }
        model.addAttribute("msg", message);

//        bonus
        List<Integer> rolls = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            rolls.add(randomNum);
        }
        model.addAttribute("rolls", rolls);
//        and then output the rolls onto the html to the view (use a for each loop). Prepare statements for each integer in the loop (if it matches the guess)

        return "roll-dice-result";
    }

}
