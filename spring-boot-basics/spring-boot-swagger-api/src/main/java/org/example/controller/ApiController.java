package org.example.controller;


import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/post/{id}")
    public String post(@PathVariable(name = "id") Long id) {
        return "post with id " + id;
    }

    @PutMapping("/put/{name}")
    public String put(@PathVariable(name = "name") String name) {
        return "put with name " + name;
    }
}
