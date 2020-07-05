package com.me.registrationtask.usecase

import com.me.registrationtask.repository.IUserRepository

class AuthenticationTask(val userRepository: IUserRepository)