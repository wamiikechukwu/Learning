package com.me.registrationtask.repository

import com.me.registrationtask.module.UserEntity

interface IUserRepository {

    fun saveUser(user: UserEntity)
    fun login(Username: String, password: String): UserEntity

}