package com._404.cosmos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class BasicController {

    @GetMapping("/test")
    public Object test() {
        return new ResponseEntity<>("hello cosmos!</br>Time : " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd EEE HH:mm:ss")), HttpStatus.OK);
    }

}
