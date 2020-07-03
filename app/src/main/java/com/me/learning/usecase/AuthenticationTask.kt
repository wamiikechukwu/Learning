package com.me.learning.usecase

import com.me.learning.model.UserEntity
import com.me.learning.repository.IUserRepository
import java.lang.IllegalArgumentException

class AuthenticationTask constructor(private val userRepository: IUserRepository) {

    fun executeTask(username: String, password: String): UserEntity {
        if (username.isEmpty()) throw  IllegalArgumentException("username is invalid")

        if (password.isEmpty()) throw  IllegalArgumentException("password is required")

        return userRepository.login(username, password)
    }

}