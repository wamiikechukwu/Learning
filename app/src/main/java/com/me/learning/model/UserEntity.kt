package com.me.learning.model

/**
 * UserEntity
 * */
data class UserEntity(
    /***
     * I'm using var so that i can change the values later (mutable)
     * if use val it means you can't change the value of the property (immutable)
     * use the var/val with caution
     */
    var id:Int,
    var username: String,
    var name: String,
    var password: String,
    var email: String
)