package com.learning.ecommerceapp.ecommerceapp.service

import com.learning.ecommerceapp.ecommerceapp.dto.User
import com.learning.ecommerceapp.ecommerceapp.dto.UserRequest
import com.learning.ecommerceapp.ecommerceapp.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(request: UserRequest): User {
        val user = User(name = request.name, email = request.email)
        return userRepository.save<User>(user)
    }

    fun getAllUsers(): List<User> {
        return userRepository.findAll()
    }
}