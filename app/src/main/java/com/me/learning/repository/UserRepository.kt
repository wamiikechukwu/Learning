package com.me.learning.repository

import com.me.learning.db.dao.UserDao
import com.me.learning.model.UserEntity

class UserRepository constructor(private val userDao: UserDao) : IUserRepository {
    override fun saveUser(userEntity: UserEntity) {
        userDao.addUser(userEntity)
    }

    override fun login(username: String, password: String): UserEntity {
        return userDao.getUser(username, password)
    }
}