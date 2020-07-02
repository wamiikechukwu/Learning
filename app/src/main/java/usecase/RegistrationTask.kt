package usecase

import Repository.IUserRepository

class RegistrationTask(
    val IUserRepository: IUserRepository,
    val Username: String,
    val Name: String,
    val Password: String,
    val Email: String
)
//  THE CLASS WITH IUserRepository AS A PARAMETER AND THE FIELDS.
//  I BELIEVED THIS IS WHAT YOU WANTED
