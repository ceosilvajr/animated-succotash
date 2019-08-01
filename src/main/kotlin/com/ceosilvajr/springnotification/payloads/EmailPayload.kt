package com.ceosilvajr.springnotification.payloads

/**
 * @author ceosilvajr@gmail.com
 */
data class EmailPayload(
        var emailFrom: String = "",
        var emailTo: String = "",
        var templateId: String = "",
        val customValues: Map<String, Any>
)
