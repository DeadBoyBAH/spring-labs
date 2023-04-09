package ru.rsreu.pukin.springlabs.persist.entity

import javax.persistence.*

@Table(name = "client")
@Entity
data class ClientEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
    val id: Int? = null,

    @Column(name = "firstname", nullable = false)
    val firstname: String,

    @Column(name = "lastname", nullable = false)
    val lastname: String,

    @Column(name = "patronymic")
    val patronymic: String? = null,

    @Column(name = "phone", nullable = false, length = 12)
    val phone: String,

    @Column(name = "email")
    val email: String,

    @Column(name = "gender", length = 1)
    val gender: Char,

    @Column(name = "international_passport")
    val internationalPassport: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_info_id")
    val userInfo: UserInfoEntity,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "passport_data_id")
    val passportData: PassportDataEntity,
)