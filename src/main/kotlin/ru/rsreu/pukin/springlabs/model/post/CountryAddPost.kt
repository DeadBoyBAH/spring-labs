package ru.rsreu.pukin.springlabs.model.post

import javax.validation.constraints.*

data class CountryAddPost(
    @field:NotBlank(message = "Имя не должно быть пустым")
    val name: String? = null,
    val partWorld: String? = null,
    @field:NotBlank(message = "Названите фона не должно быть пустым")
    val image: String? = null,
    @field:NotBlank(message = "Описание не должно быть пустым")
    val description: String? = null
)