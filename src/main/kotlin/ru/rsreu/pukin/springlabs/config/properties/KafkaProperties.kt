package ru.rsreu.pukin.springlabs.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "kafka")
class KafkaProperties(
    val username: String,
    val password: String,
    val bootstrapServers: List<String>
)