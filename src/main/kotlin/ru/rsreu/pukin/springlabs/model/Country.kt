package ru.rsreu.pukin.springlabs.model

data class Country(
    val id: Int? = null,
    val name: String,
    val partWorld: String,
    val image: String,
    val description: String
)