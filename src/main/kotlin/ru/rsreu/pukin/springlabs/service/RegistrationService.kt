package ru.rsreu.pukin.springlabs.service

import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service
import ru.rsreu.pukin.springlabs.persist.entity.ClientEntity
import ru.rsreu.pukin.springlabs.persist.entity.PassportDataEntity
import ru.rsreu.pukin.springlabs.persist.entity.UserInfoEntity
import ru.rsreu.pukin.springlabs.persist.enum.Role
import ru.rsreu.pukin.springlabs.persist.enum.Status
import ru.rsreu.pukin.springlabs.persist.repository.ClientEntityRepository
import ru.rsreu.pukin.springlabs.persist.repository.PassportDataEntityRepository
import ru.rsreu.pukin.springlabs.persist.repository.UserInfoEntityRepository
import ru.rsreu.pukin.springlabs.security.UserPostForm
import java.time.LocalDate

@Service
class RegistrationService(
    private val userInfoEntityRepository: UserInfoEntityRepository,
    private val clientEntityRepository: ClientEntityRepository,
    private val passportDataEntityRepository: PassportDataEntityRepository
) {

    fun register(userPostForm: UserPostForm) {
        userInfoEntityRepository.save(
            UserInfoEntity(
                email = userPostForm.email!!,
                password = BCrypt.hashpw(userPostForm.password!!, BCrypt.gensalt()),
                role = Role.USER,
                status = Status.ACTIVE
            )
        ).let { userInfo ->

            passportDataEntityRepository.save(
                PassportDataEntity(
                    passportSeries = userPostForm.passportSeries!!,
                    passportNumber = userPostForm.passportNumber!!,
                    birthdate = LocalDate.parse(userPostForm.birthdate!!),
                    birthplace = userPostForm.birthplace!!
                )
            ).let {
                clientEntityRepository.save(
                    ClientEntity(
                        id = it.id,
                        firstname = userPostForm.firstname!!,
                        lastname = userPostForm.lastname!!,
                        patronymic = userPostForm.patronymic,
                        phone = userPostForm.phone!!,
                        email = userPostForm.email,
                        gender = userPostForm.gender!!,
                        internationalPassport = userPostForm.internationalPassport,
                        userInfo = userInfo,
                        passportData = it
                    )
                )
            }
        }
    }
}