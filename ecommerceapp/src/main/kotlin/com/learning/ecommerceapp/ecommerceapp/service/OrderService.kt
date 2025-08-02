package com.learning.ecommerceapp.ecommerceapp.service

import com.learning.ecommerceapp.ecommerceapp.dto.*
import com.learning.ecommerceapp.ecommerceapp.repository.OrderItemRepository
import com.learning.ecommerceapp.ecommerceapp.repository.OrderRepository
import com.learning.ecommerceapp.ecommerceapp.repository.ProductRepository
import com.learning.ecommerceapp.ecommerceapp.repository.UserRepository
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime

@Service
class OrderService(
    private val userRepository: UserRepository,
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    private val orderItemRepository: OrderItemRepository
) {

    fun placeOrder(request: OrderRequest): OrderResponse {
        val user: User = userRepository.findById(request.userId)
            .orElseThrow { IllegalArgumentException("User not found") }

        val orderItems = request.items.map { itemReq ->
            val product = productRepository.findById(itemReq.productId)
                .orElseThrow { IllegalArgumentException("Product not found: ${itemReq.productId}") }

            OrderItem(
                product = product,
                quantity = itemReq.quantity,
                order = Order(user = user) // temporary dummy, will be replaced
            )
        }

        val order = Order(
            user = user,
            createdAt = LocalDateTime.now()
        )
        val savedOrder = orderRepository.save(order)

        val savedItems = orderItems.map {
            it.copy(order = savedOrder)
        }
        orderItemRepository.saveAll(savedItems)

        val responseItems = savedItems.map {
            val subtotal = it.product.price.multiply(BigDecimal(it.quantity))
            OrderItemSummary(
                productId = it.product.id,
                productName = it.product.name,
                quantity = it.quantity,
                price = it.product.price,
                subtotal = subtotal
            )
        }

        val total = responseItems.map { it.subtotal }.reduce(BigDecimal::add)

        return OrderResponse(
            orderId = savedOrder.id,
            userId = user.id,
            createdAt = savedOrder.createdAt,
            totalAmount = total,
            items = responseItems
        )
    }
    fun getOrdersByUser(userId: Long): List<OrderResponse> {
        val orders : List<Order> = orderRepository.findAllByUserId(userId)
        return orders.map { order ->
            order.toOrderResponse()
        }
    }
}