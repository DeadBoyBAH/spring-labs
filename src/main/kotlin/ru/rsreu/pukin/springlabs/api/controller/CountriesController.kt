package ru.rsreu.pukin.springlabs.api.controller

import javax.validation.Valid
import org.slf4j.LoggerFactory
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.rsreu.pukin.springlabs.model.post.CountryAddPost
import ru.rsreu.pukin.springlabs.persist.repository.CountryRepository
import ru.rsreu.pukin.springlabs.persist.repository.SimpleJdbcInsertCountryRepository

@Controller
@RequestMapping("/countries")
class CountriesController(
    private val simpleJdbcInsertCountryRepository: SimpleJdbcInsertCountryRepository,
    private val countryRepository: CountryRepository
) {

    companion object {
        private val log = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun countriesPage(model: Model): String {
        val countries = countryRepository.findAll()
        model.addAttribute("countries", countries)

        return "countries/countries"
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/add")
    fun pageAdd(model: Model): String {
        model.addAttribute("countryAddPost", CountryAddPost())

        return "countries/add"
    }

    @PostMapping("/add")
    fun postAdd(@ModelAttribute @Valid countryAddPost: CountryAddPost, bindingResult: BindingResult): String {
        return if (bindingResult.hasErrors()) {
            "countries/add"
        } else {
            log.info("post success with body: $countryAddPost")
            try {
                val id = simpleJdbcInsertCountryRepository.save(countryAddPost)
                log.info("country with id: $id inserted")
            } catch (e: Exception) {
                log.error("country not inserted. Error: ${e.message}")
            }

            "redirect:/index"
        }
    }
}