package ru.rsreu.pukin.springlabs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import ru.rsreu.pukin.springlabs.model.KafkaConsumer

@SpringBootApplication(
    exclude =
    [org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration::class]
)
@ConfigurationPropertiesScan
class SpringLabsApplication

fun main(args: Array<String>) {
    val context = runApplication<SpringLabsApplication>(*args)
    val kafkaConsumer = context.getBean(KafkaConsumer::class.java)
    println(kafkaConsumer)
}
