package net.anyjava.blogcode.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class LocalDateController {

    @GetMapping("/localdate-default")
    public LocalDate localDateDefault(@RequestParam LocalDate createdAt) {
        return createdAt;
    }

    @GetMapping("/localdate")
    public LocalDate localDate(
            @DateTimeFormat(pattern = "yyyy.MM.dd")
            @RequestParam LocalDate createdAt) {
        return createdAt;
    }
}
