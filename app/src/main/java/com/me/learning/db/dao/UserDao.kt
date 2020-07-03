package com.me.learning.db.dao

import com.me.learning.model.UserEntity

interface UserDao {
    fun addUser(userEntity: UserEntity)

    fun getUser(username: String, password: String): UserEntity
}