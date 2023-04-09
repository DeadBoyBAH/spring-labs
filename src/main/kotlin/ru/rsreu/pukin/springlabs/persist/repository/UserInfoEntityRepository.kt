package ru.rsreu.pukin.springlabs.persist.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rsreu.pukin.springlabs.persist.entity.UserInfoEntity

interface UserInfoEntityRepository : JpaRepository<UserInfoEntity, Int> {

    fun findByEmail(email: String): UserInfoEntity?
}