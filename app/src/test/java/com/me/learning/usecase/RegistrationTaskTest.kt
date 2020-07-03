package com.me.learning.usecase

import com.me.learning.model.UserEntity
import com.me.learning.repository.IUserRepository
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

/**
 * You need this annotation to tell
 * the ide to run test in JUnit 4
 **/
@RunWith(JUnit4::class)
class RegistrationTaskTest {

    /**
     * This annotation tells mockito to make a photo copy
     * of the object without affecting the original one
     *
     *In short, mocking is creating objects that simulate
     * the behavior of real objects
     * */

    @Mock
    /***
     *The lateinit keyword stands for late initialization.
     * Lateinit comes very handy when a non-null initializer
     * cannot be supplied in the constructor, but the developer
     * is certain that the variable will not be null when accessing it
     */
    lateinit var userRepository: IUserRepository

    /**
     * Here we don't annotate it with mock because is the actual class under test
     * while the annotated mock means is a dependency coming through dependency injection
     * in the constructor. so every constructor that will have a dependency will have @Mock
     * and the original class receiving the dependency doesn't have to have the annotation
     * hope is clear enough
     * */
    private lateinit var registrationTask: RegistrationTask

    // instantiating user class
    private val fakeUserEntity = UserEntity(
        id = 1,
        username = "any_username",
        name = "any_name",
        password = "any_password",
        email = "any_email"
    )


    /***
     * This annotation tells JUnit lib to run this function first before any other
     * function in this class.
     * so we can instantiate all our object here before the actual test begins
     */

    @Before
    fun setUp() {
        // this create the instance of all the @mock object
        MockitoAnnotations.initMocks(this)
        /***
         * Instantiating registration task since we used lateinit
         * so now we are passing the photocopy object to our class
         * since is a photocopy, we can manipulate it any how we like
         */
        registrationTask = RegistrationTask(userRepository)
    }

    /***
     * this annotation tells the ide that we are ready to test
     * the functions of our class
     * the message is taking from the issue #1 unit test
     *
     * if you want to test an exception
     * type expected = the exception name in the original class
     */
    @Test(expected = IllegalArgumentException::class)
    fun `should throw an exception when username is empty`() {
        /***
         * Here i don't modify the values of our object else
         * the username in fake user will be null
         * so just create a copy of the object like so below
         */
        val testUser = fakeUserEntity
        testUser.username = ""
        registrationTask.executeTask(fakeUserEntity)
    }

    /***
     * todo
     * test the rest of the exception following the above
     */


    @Test
    fun `should save the new user`() {
        registrationTask.executeTask(userEntity = fakeUserEntity)
        /***
         * Here we are checking whether the interface was actually called in the class
         * you can go back the original class and check. you will see that we called the
         * interface with function saveUser
         *
         * times indicate the number of times the function was called.
         * so we did called saveUser from the interface once
         * so that explains the 1
         * if you called it multiple times, specify the number
         * look at the function carefully. the verify calls the function after not in the verify ()
         */
        Mockito.verify(userRepository,times(1)).saveUser(userEntity = fakeUserEntity)

    }
}
