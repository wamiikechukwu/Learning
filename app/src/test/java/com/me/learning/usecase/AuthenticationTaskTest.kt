package com.me.learning.usecase

import com.me.learning.model.UserEntity
import com.me.learning.repository.IUserRepository
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

    private lateinit var authenticationTask: AuthenticationTask

    // instantiating user class
    private val fakeUserEntity = UserEntity(
        id = 1,
        username = "any_username",
        name = "any_name",
        password = "any_password",
        email = "any_email"
    )

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        authenticationTask = AuthenticationTask(userRepository)
    }

    /***
     * todo add the exception test here
     * see the registration test for reference
     */

    @Test
    fun `should return the login user data`() {
        val username = fakeUserEntity.username
        val password = fakeUserEntity.password
        /***
         * Here mockito.when is use if the interface is returning a value
         * so in the original class when login function is called this fake data
         * is returned back to the class function
         */
        Mockito.`when`(userRepository.login(username, password)).thenReturn(fakeUserEntity)
        val expected = authenticationTask.executeTask(username = username, password = password)
        println(expected)
        Mockito.verify(userRepository, times(1)).login(username = username, password = password)
    }
}