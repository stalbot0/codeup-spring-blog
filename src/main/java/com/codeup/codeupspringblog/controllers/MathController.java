package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MathController {

    @GetMapping("/add/{x}/and/{y}")
    public int add(@PathVariable int x, @PathVariable int y) {
        return x + y;
    }

    @GetMapping("/subtract/{x}/from/{y}")
    public int subtract(@PathVariable int x, @PathVariable int y) {
        return y - x;
    }

    @GetMapping("/multiply/{x}/and/{y}")
    public int multiply(@PathVariable int x, @PathVariable int y) {
        return x * y;
    }

    @GetMapping("/divide/{x}/by/{y}")
    public int divide(@PathVariable int x, @PathVariable int y) {
        return x / y;
    }

}
