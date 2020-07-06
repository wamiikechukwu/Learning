package com.me.registrationtask.repository

import com.me.registrationtask.db.UserDao
import com.me.registrationtask.module.UserEntity

class UserRepository(val userDao: UserDao) :
    IUserRepository {
    override fun saveUser(user: UserEntity) {
        userDao.saveUser(user)
    }

    override fun login(username: String, password: String): UserEntity {
        return userDao.getUser(username, password)
    }
}