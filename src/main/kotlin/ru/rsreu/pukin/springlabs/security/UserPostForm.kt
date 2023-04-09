package ru.rsreu.pukin.springlabs.security

import javax.validation.constraints.*

data class UserPostForm(
    @field:NotEmpty(message = "Логин не должен быть пустым")
    @field:Email(message = "Неправильный формат почты. Пример: test@test.ru")
    val email: String? = null,
    @field:NotBlank(message = "Пароль не должен быть пустым")
    val password: String? = null,
    @field:NotBlank(message = "Подтвержденный пароль не должен быть пустым")
    val confirmedPassword: String? = null,
    @field:NotBlank(message = "Имя не должно быть пустым")
    val firstname: String? = null,
    @field:NotBlank(message = "Фамилия не должна быть пустой")
    val lastname: String? = null,
    val patronymic: String? = null,
    @field:NotBlank(message = "Телефон не должен быть пустым")
    val phone: String? = null,
    val gender: Char? = null,
    val internationalPassport: Long? = null,
    @field:NotNull(message = "Серия паспорта не должна быть пустой")
    @field:Min(1000)
    @field:Max(9999)
    val passportSeries: Int? = null,
    @field:NotNull(message = "Номер паспорта не должен быть пустым")
    @field:Min(100000)
    @field:Max(999999)
    val passportNumber: Int? = null,
    val birthdate: String? = null,
    @field:NotBlank(message = "Место рождения не должно быть пустым")
    val birthplace: String? = null
)
