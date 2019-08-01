package com.ceosilvajr.springnotification.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

/**
 * @author ceosilvajr@gmail.com
 */
@Configuration
class NotificationAppConfig {

    @Value("\${firebase.json.path}")
    private var firebaseJsonPath: String = ""

    @Bean
    fun initializeFirebase() {
        val resource = ClassPathResource(firebaseJsonPath).inputStream
        val credentials = GoogleCredentials.fromStream(resource)
        val options = FirebaseOptions.Builder().setCredentials(credentials).build()
        FirebaseApp.initializeApp(options)
    }

}
