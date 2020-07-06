package com.me.registrationtask

import com.me.registrationtask.module.UserEntity
import com.me.registrationtask.repository.IUserRepository
import com.me.registrationtask.usecase.RegistrationTask
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.MockitoAnnotations

//TELL THE IDE TO RUN WITH JUnit$
@RunWith(JUnit4::class)

class RegistrationTaskTest {

    @Mock
    lateinit var userRepository: IUserRepository

    lateinit var registrationTask: RegistrationTask

    private val fakeUserEntity = UserEntity(
        Username = "someone",
        Name = "name",
        Password = "myPassword",
        Email = "someone@gmail.com"
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        registrationTask = RegistrationTask(userRepository)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenUserNameIsEmpty() {
        val testUserName = fakeUserEntity
        testUserName.Username = ""
        registrationTask.executeTask(testUserName)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenNameIsEmpty() {
        val testName = fakeUserEntity
        testName.Name = ""
        registrationTask.executeTask(testName)
    }

    @Test(expected = IllegalArgumentException::class)
    fun shouldThrowAnExceptionWhenEmailIsEmpty() {
        val testEmail = fakeUserEntity
        testEmail.Email = ""
        registrationTask.executeTask(testEmail)
    }

}