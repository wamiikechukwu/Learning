package com.me.registrationtask.usecase

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository

class AuthenticationTask(private val userRepository: IUserRepository) {

    fun executeTask(username: String, password: String): UserEntity {
        if (username.isEmpty()) throw IllegalArgumentException("User Name is invalid")
        if (password.isEmpty()) throw IllegalArgumentException("Password is invalid")

        return userRepository.login(username, password)
    }

}
