package com.me.registrationtask.repository

import com.me.registrationtask.db.UserDao
import com.me.registrationtask.module.UserEntity

class UserRepository(val userDao: UserDao) :
    IUserRepository {
    override fun login(Username: String, password: String): UserEntity {
        TODO("Not yet implemented")
    }
}