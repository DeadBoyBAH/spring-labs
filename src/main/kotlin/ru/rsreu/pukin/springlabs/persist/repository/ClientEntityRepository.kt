package ru.rsreu.pukin.springlabs.persist.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rsreu.pukin.springlabs.persist.entity.ClientEntity

interface ClientEntityRepository : JpaRepository<ClientEntity, Int> {

    fun findByEmail(email: String): ClientEntity
}