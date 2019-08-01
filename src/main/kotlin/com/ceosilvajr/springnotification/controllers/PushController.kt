package com.ceosilvajr.springnotification.controllers

import com.ceosilvajr.springnotification.payloads.PushPayload
import com.ceosilvajr.springnotification.services.PushServices
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
@RequestMapping("/push/")
class PushController(@Autowired val service: PushServices) {

    @PostMapping
    fun sendNotification(@RequestBody body: PushPayload): ResponseEntity<String> {
        return ResponseEntity.ok(service.pushMessage(body))
    }

}
