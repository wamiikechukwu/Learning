package com.me.registrationtask

import com.me.registrationtask.db.UserDao
import com.me.registrationtask.module.UserEntity

class UserDaoImpl : UserDao {

    //    AN ARRAYLIST THAT IS OF THE TYPE UserEntity
    private val mArrayList: ArrayList<UserEntity> = ArrayList()


    //    THE IMPORTED FUNCTION FROM THE UserDao INTERFACE
    override fun saveUser(user: UserEntity) {

//    ADDED THE USER DATA TO THE ARRAYLIST
        mArrayList.add(user)
    }

    override fun getUser(username: String, password: String): UserEntity {

//        FROM THE ARRAYLIST FIND THE USERNAME AND PASSWORD PARAMETER
        val findingUser = mArrayList.find { it.username == username && it.password == password }

//        IF ITS NOT FOUND, THROW AN EXCEPTION
        if (findingUser == null) throw NullPointerException("User Not Found")

//        ELSE RETURN THE VARIABLE
        else return findingUser
    }


}