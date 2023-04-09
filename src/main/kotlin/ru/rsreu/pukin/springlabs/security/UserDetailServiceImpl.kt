package ru.rsreu.pukin.springlabs.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.rsreu.pukin.springlabs.persist.entity.UserInfoEntity
import ru.rsreu.pukin.springlabs.persist.repository.UserInfoEntityRepository

@Service
class UserDetailsServiceImpl(
    private val userInfoRepository: UserInfoEntityRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user: UserInfoEntity =
            userInfoRepository.findByEmail(email) ?: throw UsernameNotFoundException("User doesn't exists")
        return SecurityUser.fromUser(user)
    }
}