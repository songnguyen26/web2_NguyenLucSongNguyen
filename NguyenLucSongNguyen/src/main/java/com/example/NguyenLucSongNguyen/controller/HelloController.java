package com.example.NguyenLucSongNguyen.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String Index(@RequestParam(defaultValue = "spring boot", required = false) String param) {
        return "Hello " + param;
    }

    @PostMapping("/testpost")
    public String postMethodName(@RequestBody String entity) {

        return entity;
    }

    @PutMapping("/testput/{id}")
    public String update(@PathVariable String id, @RequestBody String entity) {
        return entity;
    }

    @DeleteMapping("/testDel/{id}")
    public String delete(@PathVariable String id) {
        return "Delete with id " + id +" SuccessFull";
    }
}
