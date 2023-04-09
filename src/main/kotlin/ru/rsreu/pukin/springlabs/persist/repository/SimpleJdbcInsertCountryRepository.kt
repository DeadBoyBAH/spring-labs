package ru.rsreu.pukin.springlabs.persist.repository

import ru.rsreu.pukin.springlabs.model.post.CountryAddPost

interface SimpleJdbcInsertCountryRepository {

    fun save(countryAddPost: CountryAddPost): Number
}