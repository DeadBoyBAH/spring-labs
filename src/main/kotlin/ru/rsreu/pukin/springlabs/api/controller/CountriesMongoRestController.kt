package ru.rsreu.pukin.springlabs.api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.rsreu.pukin.springlabs.model.Country
import ru.rsreu.pukin.springlabs.service.CountriesService

@RestController
@RequestMapping("/rest/mongo/countries")
class CountriesMongoRestController(
    private val countriesService: CountriesService
) {

    @GetMapping
    fun getCountries() = ResponseEntity(countriesService.getMongoCountries(), HttpStatus.OK)

    @GetMapping("/{id}")
    fun getCountry(
        @PathVariable id: Int
    ) = ResponseEntity(countriesService.getCountryById(id), HttpStatus.OK)

    @PostMapping
    fun saveCountry(
        @RequestBody country: Country
    ) = ResponseEntity(countriesService.saveMongoCountry(country), HttpStatus.ACCEPTED)

    @PutMapping("/{id}")
    fun updateCountry(
        @PathVariable id: Int,
        @RequestBody country: Country
    ) = ResponseEntity(countriesService.updateCountry(country, id), HttpStatus.ACCEPTED)

    @DeleteMapping("/{id}")
    fun deleteCountry(
        @PathVariable id: Int
    ) = ResponseEntity(countriesService.deleteCountryById(id), HttpStatus.ACCEPTED)
}