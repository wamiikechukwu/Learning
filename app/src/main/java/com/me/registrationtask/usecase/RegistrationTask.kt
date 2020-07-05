package com.me.registrationtask.usecase

import com.me.registrationtask.repository.IUserRepository

//THIS CLASS CONSTRUCTOR TAKES IN A PARAMETER FROM THE IUserRepository AS AN OBJECT
class RegistrationTask(val userRepository: IUserRepository)
