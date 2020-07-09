package com.me.registrationtask.usecase

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)

class AuthenticationTaskTest {

    @Mock
    lateinit var userRepository: IUserRepository

    private lateinit var authenticationTaskTest: AuthenticationTask

    private val fakeUserEntity = UserEntity(
        id = 1,
        username = "myUserName",
        name = "myName",
        password = "myPassword",
        email = "myEmail@gmial.com"
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        authenticationTaskTest = AuthenticationTask(userRepository)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenUserDataIsNull() {
        authenticationTaskTest.executeTask(username = "", password = "")
    }

    @Test
    fun shouldGetAuthorizedUserData() {
        val fakeUserName = fakeUserEntity.username
        val fakePassword = fakeUserEntity.password

        Mockito.`when`(userRepository.login(fakeUserName, fakePassword)).thenReturn(fakeUserEntity)
        val expected =
            authenticationTaskTest.executeTask(username = fakeUserName, password = fakePassword)
        print(expected)
        Mockito.verify(userRepository, times(1))
            .login(username = fakeUserName, password = fakePassword)
    }
}