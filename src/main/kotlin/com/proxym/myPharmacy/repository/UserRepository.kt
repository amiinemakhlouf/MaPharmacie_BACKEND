package com.proxym.myPharmacy.repository

import com.proxym.myPharmacy.model._User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository :JpaRepository<_User,Int> {

    fun findByEmail(email:String):_User?


}