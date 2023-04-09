package ru.rsreu.pukin.springlabs.api.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.rsreu.pukin.springlabs.security.UserPostForm
import ru.rsreu.pukin.springlabs.service.RegistrationService
import javax.validation.Valid

@Controller
@RequestMapping("auth")
class AuthController(
    private val registrationService: RegistrationService
) {

    @GetMapping("login")
    fun loginPage(): String = "auth/login"

    @PostMapping("login")
    fun loginPost(): String = "redirect:/index"

    @GetMapping("registration")
    fun registration(model: Model): String {
        model.addAttribute("userPostForm", UserPostForm(gender = 'M', birthdate = "2000-01-01"))
        return "auth/registration"
    }

    @PostMapping("registration")
    fun registrationResult(@ModelAttribute @Valid userPostForm: UserPostForm, bindingResult: BindingResult): String {
        return if (bindingResult.hasErrors() || userPostForm.password != userPostForm.confirmedPassword) {
            "auth/registration"
        } else {
            registrationService.register(userPostForm)
            "redirect:/auth/login"
        }
    }

    @GetMapping("logout")
    fun logoutPage(): String {
        return "auth/logout"
    }
}