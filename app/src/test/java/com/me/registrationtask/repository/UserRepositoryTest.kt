package com.me.registrationtask.repository

import com.me.registrationtask.db.UserDao
import com.me.registrationtask.module.UserEntity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class UserRepositoryTest {

    @Mock
    lateinit var userDao: UserDao

    lateinit var userRepository: UserRepository

    var fakeUser = UserEntity(
        id = 1,
        username = "username",
        name = "name",
        password = "password",
        email = "email"
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        userRepository = UserRepository(userDao)
    }

    @Test
    fun saveUser() {
        userRepository.saveUser(fakeUser)
        Mockito.verify(userDao, times(1)).saveUser(fakeUser)
    }

    @Test
    fun login() {
        val fakeUsername = fakeUser.username
        val fakePassword = fakeUser.password
        userRepository.login(fakeUsername, fakePassword)
        Mockito.verify(userDao, times(1)).getUser(fakeUsername, fakePassword)
    }
}