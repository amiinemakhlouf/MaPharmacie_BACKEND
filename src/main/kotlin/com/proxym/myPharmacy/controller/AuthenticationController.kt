package com.proxym.myPharmacy.controller

import com.proxym.myPharmacy.dto.LoginDto
import com.proxym.myPharmacy.dto.RegisterDto
import com.proxym.myPharmacy.model.User
import com.proxym.myPharmacy.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api")

class AuthenticationController(val userService: UserService) {

    @PostMapping("register")
    fun register(@RequestBody body: RegisterDto): ResponseEntity<User> {
        val user = User().apply {
            this.email = body.email
            this.password = body.password
        }

        userService.save(user)
        return ResponseEntity.ok(this.userService.save(user))
   }



    @PostMapping("login")
    fun login(@RequestBody body: LoginDto,response: HttpServletResponse): ResponseEntity<Any> {
       if(userService.findByEmail(body.email)==null){
           return ResponseEntity.badRequest().body("user not exist")

       }
        val encoder = BCryptPasswordEncoder()
       if(!encoder.matches(body.password, userService.findByEmail(body.email)!!.password)) {
           return ResponseEntity.badRequest().body("wrong password")
       }
        val issuer= body.email
        val jwt= Jwts.builder().setIssuer(issuer).signWith(SignatureAlgorithm.HS512, "HRlELXqpSB").compact()
        val cookie=Cookie("jwt",jwt)
        response.addCookie(cookie)
        return ResponseEntity.ok(jwt)


    }


    @GetMapping("testJwt")
    fun testJwt(@CookieValue("jwt") jwt:String? ):ResponseEntity<Any>
    {
        val  body=Jwts.parser().setSigningKey("HRlELXqpSB").parseClaimsJws(jwt).body
        return  ResponseEntity.ok(body)

    }


    @GetMapping("test")
    fun test()="amine"
}