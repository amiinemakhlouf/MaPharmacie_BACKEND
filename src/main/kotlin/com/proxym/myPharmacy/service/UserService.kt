package com.proxym.myPharmacy.service

import com.proxym.myPharmacy.model._User
import com.proxym.myPharmacy.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (val userRepository: UserRepository){

    fun save(user: _User):_User{
        userRepository.save(user)
        return user
    }
    fun findByEmail(email:String):_User?
    {
       return  userRepository.findByEmail(email)
    }

}