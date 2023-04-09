package ru.rsreu.pukin.springlabs.persist.enum

import org.springframework.security.core.authority.SimpleGrantedAuthority
import java.util.stream.Collectors

enum class Role(permissions: Set<Permission>) {
    USER(mutableSetOf(Permission.DEVELOPERS_READ)), ADMIN(
        mutableSetOf(
            Permission.DEVELOPERS_READ,
            Permission.DEVELOPERS_WRITE
        )
    ),
    MANAGER(mutableSetOf(
        Permission.DEVELOPERS_READ,
        Permission.DEVELOPERS_WRITE
    ));

    private val permissions: Set<Permission> = permissions
    private fun getPermissions(): Set<Permission> {
        return permissions
    }

    val authorities: Set<SimpleGrantedAuthority>
        get() = getPermissions().stream()
            .map { permission: Permission ->
                SimpleGrantedAuthority(
                    permission.permission
                )
            }
            .collect(Collectors.toSet())

}