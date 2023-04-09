package ru.rsreu.pukin.springlabs.model

data class KafkaConsumer(
    val username: String,
    val password: String,
    val bootstrapServers: List<String>
)