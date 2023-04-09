package ru.rsreu.pukin.springlabs.persist.repository.impl

import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import ru.rsreu.pukin.springlabs.model.post.CountryAddPost
import ru.rsreu.pukin.springlabs.persist.repository.SimpleJdbcInsertCountryRepository
import javax.sql.DataSource

@Repository
class ImplSimpleJdbcInsertCountryRepository(
    private val dataSource: DataSource
) : SimpleJdbcInsertCountryRepository {

    private val jdbcInsert = SimpleJdbcInsert(dataSource).withTableName("Country")
        .usingGeneratedKeyColumns("id")

    override fun save(countryAddPost: CountryAddPost): Number {
        val parameters = mutableMapOf<String, Any?>()
        parameters["name"] = countryAddPost.name
        parameters["description"] = countryAddPost.description
        parameters["part_world"] = countryAddPost.partWorld
        parameters["image"] = countryAddPost.image

        return jdbcInsert.executeAndReturnKey(parameters)
    }
}