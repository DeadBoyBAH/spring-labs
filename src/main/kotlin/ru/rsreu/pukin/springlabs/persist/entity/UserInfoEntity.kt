package ru.rsreu.pukin.springlabs.persist.entity

import javax.persistence.*
import ru.rsreu.pukin.springlabs.persist.enum.Role
import ru.rsreu.pukin.springlabs.persist.enum.Status

@Table(
    name = "user_info", indexes = [
        Index(name = "user_info_email_key", columnList = "email", unique = true)
    ]
)
@Entity
data class UserInfoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_info_id", nullable = false)
    val id: Int? = null,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "password", nullable = false)
    val password: String,

    @Column(name = "role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val role: Role,

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    val status: Status,
)