package com.learning.ecommerceapp.ecommerceapp.repository

import com.learning.ecommerceapp.ecommerceapp.dto.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Long>
