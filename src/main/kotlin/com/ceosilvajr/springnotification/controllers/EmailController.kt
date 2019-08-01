package com.ceosilvajr.springnotification.controllers

import com.ceosilvajr.springnotification.payloads.EmailPayload
import com.ceosilvajr.springnotification.services.EmailService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author ceosilvajr@gmail.com
 */
@RestController
@RequestMapping("/email/")
class EmailController(@Autowired val service: EmailService) {

    @PostMapping
    fun sendEmail(@RequestBody body: EmailPayload): ResponseEntity<String> {
        return ResponseEntity.ok(service.sendEmail(body))
    }
}
