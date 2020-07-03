package com.me.learning.usecase

import com.me.learning.repository.IUserRepository

class AuthenticationTask constructor(private val userRepository: IUserRepository)