package com.proxym.myPharmacy.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
class _User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id=0
    @Column(unique = true)
    var email:String=""
    @Column
    var password:String=""
        set(value) {
            val bCryptPasswordEncoder =BCryptPasswordEncoder()
            field=bCryptPasswordEncoder.encode(value)
        }





}
