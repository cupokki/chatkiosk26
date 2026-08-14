package io.github.cupokki.chatkiosk26.store.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StoreController {


    @GetMapping("/")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok().build();
    }
}
