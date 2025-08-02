package com.learning.ecommerceapp.ecommerceapp.repository

import com.learning.ecommerceapp.ecommerceapp.dto.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>