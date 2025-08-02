package com.learning.ecommerceapp.ecommerceapp.repository

import com.learning.ecommerceapp.ecommerceapp.dto.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>