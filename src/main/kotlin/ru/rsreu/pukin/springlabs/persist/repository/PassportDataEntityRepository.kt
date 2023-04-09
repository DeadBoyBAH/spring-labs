package ru.rsreu.pukin.springlabs.persist.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.rsreu.pukin.springlabs.persist.entity.PassportDataEntity

interface PassportDataEntityRepository : JpaRepository<PassportDataEntity, Int> {
}