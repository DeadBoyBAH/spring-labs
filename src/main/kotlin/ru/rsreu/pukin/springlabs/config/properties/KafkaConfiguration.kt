package ru.rsreu.pukin.springlabs.config.properties

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import ru.rsreu.pukin.springlabs.model.KafkaConsumer

@Configuration
class KafkaConfiguration(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    @Profile("dev")
    fun kafkaConsumer() = KafkaConsumer(
        kafkaProperties.username, kafkaProperties.password, kafkaProperties.bootstrapServers
    )
}