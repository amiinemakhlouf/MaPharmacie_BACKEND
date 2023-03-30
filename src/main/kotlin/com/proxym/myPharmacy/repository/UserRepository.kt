package com.proxym.myPharmacy.repository

import com.proxym.myPharmacy.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository :JpaRepository<User,Int> {

    fun findByEmail(email:String):User?


}