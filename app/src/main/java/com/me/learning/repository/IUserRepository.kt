package com.me.learning.repository

import com.me.learning.model.UserEntity

interface IUserRepository {
    fun saveUser(userEntity: UserEntity)
    fun login(username: String, password: String): UserEntity
}