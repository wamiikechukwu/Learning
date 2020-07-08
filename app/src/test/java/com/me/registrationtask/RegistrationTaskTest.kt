package com.me.registrationtask

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository
import com.me.registrationtask.usecase.RegistrationTask
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.internal.verification.VerificationModeFactory.times

//TELL THE IDE TO RUN WITH JUnit$
@RunWith(JUnit4::class)

class RegistrationTaskTest {

    @Mock
    lateinit var userRepository: IUserRepository

    private lateinit var registrationTask: RegistrationTask

    private val fakeUserEntity = UserEntity(
        id = 1,
        username = "someone",
        name = "name",
        password = "myPassword",
        email = "someone@gmail.com"
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        registrationTask = RegistrationTask(userRepository)
    }

    @Test(expected = IllegalArgumentException::class)

    fun shouldThrowAnExceptionWhenUserNameIsEmpty() {
        val testUserName = fakeUserEntity
        testUserName.username = ""
        registrationTask.executeTask(testUserName)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenNameIsEmpty() {
        val testName = fakeUserEntity
        testName.name = ""
        registrationTask.executeTask(testName)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenEmailIsEmpty() {
        val testEmail = fakeUserEntity
        testEmail.email = ""
        registrationTask.executeTask(testEmail)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenPasswordIsEmpty() {
        val testPassword = fakeUserEntity
        testPassword.password = ""
        registrationTask.executeTask(testPassword)
    }

    @Test
    fun shouldSaveTheNewUser() {
        registrationTask.executeTask(userEntity = fakeUserEntity)
        Mockito.verify(userRepository, times(1)).saveUser(user = fakeUserEntity)
    }
}
