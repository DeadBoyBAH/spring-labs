package ru.rsreu.pukin.springlabs.persist.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.rsreu.pukin.springlabs.persist.entity.MongoCountryEntity

interface MongoCountryRepository : MongoRepository<MongoCountryEntity, Long> {
}