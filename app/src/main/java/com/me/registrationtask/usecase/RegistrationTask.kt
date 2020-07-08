package com.me.registrationtask.usecase

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository

//THIS CLASS CONSTRUCTOR TAKES IN A PARAMETER FROM THE IUserRepository AS AN OBJECT
class RegistrationTask constructor(private val userRepository: IUserRepository) {

    fun executeTask(userEntity: UserEntity) {

        if (userEntity.username.isEmpty()) throw IllegalArgumentException("Username is empty...")
        if (userEntity.name.isEmpty()) throw IllegalArgumentException("Name is empty...")
        if (userEntity.password.isEmpty()) throw IllegalArgumentException("Password is empty...")
        if (userEntity.email.isEmpty()) throw IllegalArgumentException("Email is empty...")

        userRepository.saveUser(userEntity)
    }
}
