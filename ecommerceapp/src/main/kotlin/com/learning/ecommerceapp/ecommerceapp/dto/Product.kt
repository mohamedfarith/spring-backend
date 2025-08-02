package com.learning.ecommerceapp.ecommerceapp.dto

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val price: BigDecimal,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val orderItems: List<OrderItem> = emptyList()
)