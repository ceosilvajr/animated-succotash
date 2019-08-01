package com.ceosilvajr.springnotification.payloads

/**
 * @author ceosilvajr@gmail.com
 */
data class PushPayload(
        var deviceToken: String = "",
        var message: String = "",
        var title: String? = null,
        var data: Map<String, Any>
)
