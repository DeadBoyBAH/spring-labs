package ru.rsreu.pukin.springlabs.persist.enum

enum class Permission(val permission: String) {
    DEVELOPERS_READ("developers:read"), DEVELOPERS_WRITE("developers:write"), ADMIN("admin");
}