package ru.rsreu.pukin.springlabs.api.controller

import javax.websocket.server.PathParam
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class StartController {

    @GetMapping("/hello/{name}")
    fun helloUser(
        @PathVariable name: String, model: Model
    ): String {
        model.addAttribute("name", name)

        return "hello"
    }

    @GetMapping("/index")
    fun startPage() = "index"
}