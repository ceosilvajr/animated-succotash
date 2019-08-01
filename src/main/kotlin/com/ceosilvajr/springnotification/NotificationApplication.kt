package com.ceosilvajr.springnotification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SpringNotificationApplication : SpringBootServletInitializer()

@RestController
@RequestMapping("/")
class MainController {
    @GetMapping
    fun mainPath(): String {
        return "Hello Notification!"
    }
}

fun main(args: Array<String>) {
    runApplication<SpringNotificationApplication>(*args)
}
