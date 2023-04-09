package ru.rsreu.pukin.springlabs.persist.entity

import java.time.LocalDate
import javax.persistence.*

@Table(name = "passport_data")
@Entity
data class PassportDataEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passport_data_id", nullable = false)
    val id: Int? = null,

    @Column(name = "passport_number", nullable = false)
    val passportNumber: Int,

    @Column(name = "passport_series", nullable = false)
    val passportSeries: Int,

    @Column(name = "birthdate", nullable = false)
    val birthdate: LocalDate,

    @Column(name = "birthplace", length = 200)
    val birthplace: String
)