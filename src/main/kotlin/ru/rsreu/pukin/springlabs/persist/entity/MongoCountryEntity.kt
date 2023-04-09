package ru.rsreu.pukin.springlabs.persist.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import ru.rsreu.pukin.springlabs.model.Country


@Document(collection = "countries")
data class MongoCountryEntity(
    @Id
    val id: Int? = null,
    var name: String,
    var partWorld: String,
    var image: String,
    var description: String
) {

    fun mapToCountry() = Country(
        this.id!!, this.name, this.partWorld, this.image, this.description
    )
}