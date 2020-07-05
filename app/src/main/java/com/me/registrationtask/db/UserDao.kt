package com.me.registrationtask.db

import com.me.registrationtask.module.UserEntity

interface UserDao {
    fun saveUser(user: UserEntity) {

    }

    fun getUser(username: String, password: String): UserEntity

}