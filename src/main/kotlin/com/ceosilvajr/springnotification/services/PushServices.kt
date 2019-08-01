package com.ceosilvajr.springnotification.services

import com.ceosilvajr.springnotification.payloads.PushPayload
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingException
import com.google.firebase.messaging.Message
import com.google.firebase.messaging.Notification
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.logging.Logger

/**
 * @author ceosilvajr@gmail.com
 */
@Service
class PushServices {

    private val LOGGER = Logger.getLogger(PushServices::class.java.name)

    @Value("\${firebase.success.response}")
    private val successResponse = ""

    fun pushMessage(payload: PushPayload): String {
        val notification = Notification(payload.title, payload.message)
        val firebaseBuilder = Message.builder()
                .setToken(payload.deviceToken)
                .setNotification(notification)
        payload.data.entries.forEach {
            firebaseBuilder.putData(it.key, it.value.toString())
        }
        val firebaseMessage = firebaseBuilder.build()
        sendPush(firebaseMessage)
        return successResponse
    }

    private fun sendPush(firebaseMessage: Message) {
        try {
            val response = FirebaseMessaging.getInstance().send(firebaseMessage)
            LOGGER.info(response)
        } catch (e: FirebaseMessagingException) {
            LOGGER.severe(e.toString())
        }
    }
}
