package com.learning.ecommerceapp.ecommerceapp.dto

import jakarta.persistence.*

@Entity
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    val order: Order,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val product: Product,

    val quantity: Int
)

fun OrderItem.toOrderItemSummary(): OrderItemSummary {
    return OrderItemSummary(

        productId = product.id,
        productName = product.name,
        quantity = this.quantity,
        price = product.price,
        subtotal = order.orderItems.sumOf { it.product.price }
    )
}