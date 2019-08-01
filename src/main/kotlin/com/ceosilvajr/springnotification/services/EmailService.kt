package com.ceosilvajr.springnotification.services

import com.ceosilvajr.springnotification.payloads.EmailPayload
import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.SendGrid
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Email
import com.sendgrid.helpers.mail.objects.Personalization
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.logging.Logger

/**
 * @author ceosilvajr@gmail.com
 */
@Service
class EmailService {

    private val LOGGER = Logger.getLogger(EmailService::class.java.name)

    @Value("\${sendgrid.api.key}")
    private var sendGridApiKey: String = ""

    @Value("\${sendgrid.success.response}")
    private var successResponse = ""

    fun sendEmail(payload: EmailPayload): String {
        val personalization = Personalization().apply {
            this.addTo(Email(payload.emailTo))
            payload.customValues?.entries?.forEach {
                this.addDynamicTemplateData(it.key, it.value)
            }
        }
        val mail = Mail().apply {
            this.from = Email(payload.emailFrom)
            this.templateId = payload.templateId
            this.addPersonalization(personalization)
        }
        sendEmail(mail)
        return successResponse
    }

    private fun sendEmail(mail: Mail) {
        try {
            val sendGrid = SendGrid(sendGridApiKey)
            val request = Request()
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            sendGrid.api(request).body
        } catch (e: Exception) {
            LOGGER.severe(e.message)
        }
    }
}
