package com._404.cosmos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class BasicController {

    @GetMapping("/test")
    public Object test() {
        return new ResponseEntity<>("hello back!\nTime : " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy MM dd EEE HH:mm:ss")), HttpStatus.OK);
    }

}
