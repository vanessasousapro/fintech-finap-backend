package br.com.finap.fintech_finap_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstController {

    @GetMapping
    public String helloGuys() {
        return "Hello Guys!";
    }

    @GetMapping("/fiap")
    public String helloFiapPeople() {
        return "Hello Fiap People!";
    }
}
