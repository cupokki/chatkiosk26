package io.github.cupokki.chatkiosk26.store.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

    @GetMapping("/")
    public String get() {
        return "test";
    }
}
