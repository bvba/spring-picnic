package com._404.cosmos.springpicnic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@SpringBootApplication
@RestController
class SpringPicnicApplication {
    @GetMapping("/home")
    fun home(): String {
        return ZonedDateTime.now(ZoneId.of("Asia/Seoul")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    }
}

fun main(args: Array<String>) {
    runApplication<SpringPicnicApplication>(*args)
}
