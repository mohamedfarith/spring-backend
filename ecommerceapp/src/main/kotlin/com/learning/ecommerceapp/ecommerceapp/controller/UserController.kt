package com.learning.ecommerceapp.ecommerceapp.controller

import com.learning.ecommerceapp.ecommerceapp.dto.User
import com.learning.ecommerceapp.ecommerceapp.dto.UserRequest
import com.learning.ecommerceapp.ecommerceapp.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody request: UserRequest): ResponseEntity<User> {
        return ResponseEntity.ok(userService.createUser(request))
    }

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.getAllUsers())
    }
}