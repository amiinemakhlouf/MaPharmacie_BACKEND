package com.proxym.myPharmacy.service

import com.proxym.myPharmacy.model.User
import com.proxym.myPharmacy.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (val userRepository: UserRepository){

    fun save(user: User):User{
        userRepository.save(user)
        return user
    }
    fun findByEmail(email:String):User?
    {
       return  userRepository.findByEmail(email)
    }

}