package com.me.registrationtask.usecase

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository

//THIS CLASS CONSTRUCTOR TAKES IN A PARAMETER FROM THE IUserRepository AS AN OBJECT
class RegistrationTask constructor(private val userRepository: IUserRepository) {

    fun executeTask(userEntity: UserEntity) {

        if (userEntity.Username.isEmpty()) throw IllegalArgumentException("Username is empty...")
        if (userEntity.Name.isEmpty()) throw IllegalArgumentException("Name is empty...")
        if (userEntity.Password.isEmpty()) throw IllegalArgumentException("Password is empty...")
        if (userEntity.Email.isEmpty()) throw IllegalArgumentException("Email is empty...")

        userRepository.saveUser(userEntity)
    }
}
