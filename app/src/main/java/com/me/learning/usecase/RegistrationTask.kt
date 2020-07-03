package com.me.learning.usecase

import com.me.learning.model.UserEntity
import com.me.learning.repository.IUserRepository

class RegistrationTask constructor(private val userRepository: IUserRepository) {

    fun executeTask(userEntity: UserEntity) {
        /**
         * We are validation here
         * IllegalArgumentException
         * This exception indicates that a method is called with incorrect input arguments.
         * Then, the only thing you must do is correct the values of the input parameters
         * */

        if (userEntity.username.isEmpty()) throw IllegalArgumentException("username is required")
        if (userEntity.name.isEmpty()) throw IllegalArgumentException("name is required")
        if (userEntity.password.isEmpty()) throw IllegalArgumentException("password is required")
        if (userEntity.email.isEmpty()) throw IllegalArgumentException("email is required")

        userRepository.saveUser(userEntity)
    }

}

