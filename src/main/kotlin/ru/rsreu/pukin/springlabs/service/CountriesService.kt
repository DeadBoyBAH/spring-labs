package ru.rsreu.pukin.springlabs.service

import org.springframework.stereotype.Service
import ru.rsreu.pukin.springlabs.model.Country
import ru.rsreu.pukin.springlabs.persist.entity.CountryEntity
import ru.rsreu.pukin.springlabs.persist.entity.MongoCountryEntity
import ru.rsreu.pukin.springlabs.persist.repository.CountryRepository
import ru.rsreu.pukin.springlabs.persist.repository.MongoCountryRepository

@Service
class CountriesService(
     private val countryRepository: CountryRepository,
    private val mongoCountryRepository: MongoCountryRepository
) {

    fun getCountries(): List<Country> =
        countryRepository.findAll().map {
            it.mapToCountry()
        }

    fun getMongoCountries(): List<Country> =
        mongoCountryRepository.findAll().map {
            it.mapToCountry()
        }

    fun getCountryById(id: Int): Country =
        countryRepository.findById(id).get().mapToCountry()

    fun saveCountry(country: Country): Country =
        countryRepository.save(
            CountryEntity(
                name = country.name,
                partWorld = country.partWorld,
                image = country.image,
                description = country.description
            )
        ).mapToCountry()

    fun saveMongoCountry(country: Country): Country =
        mongoCountryRepository.save(
            MongoCountryEntity(
                id = country.id,
                name = country.name,
                partWorld = country.partWorld,
                image = country.image,
                description = country.description
            )
        ).mapToCountry()

    fun updateCountry(country: Country, id: Int) =
        countryRepository.getById(id).apply {
            name = country.name
            partWorld = country.partWorld
            image = country.image
            description = country.description
        }.mapToCountry()

    fun deleteCountryById(id: Int) =
        countryRepository.deleteById(id)
}