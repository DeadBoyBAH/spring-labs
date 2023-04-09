package ru.rsreu.pukin.springlabs.persist.entity

import ru.rsreu.pukin.springlabs.model.Country
import javax.persistence.*


@Entity
@Table(name = "Country")
data class CountryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null,
    @Column(name = "name")
    var name: String,
    @Column(name = "part_world")
    var partWorld: String,
    @Column(name = "image")
    var image: String,
    @Column(name = "description")
    var description: String
) {

    fun mapToCountry() = Country(
        this.id!!, this.name, this.partWorld, this.image, this.description
    )
}