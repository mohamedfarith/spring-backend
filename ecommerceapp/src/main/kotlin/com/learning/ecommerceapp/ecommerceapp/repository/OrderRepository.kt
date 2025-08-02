package com.learning.ecommerceapp.ecommerceapp.repository

import com.learning.ecommerceapp.ecommerceapp.dto.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order,Long>{
    fun findAllByUserId(userId: Long): List<Order>
}