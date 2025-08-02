package com.learning.ecommerceapp.ecommerceapp.dto

import java.math.BigDecimal

data class ProductRequest(
    val name: String,
    val price: BigDecimal
)