package com.learning.book_store_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BookStoreApiApplication

fun main(args: Array<String>) {
	runApplication<BookStoreApiApplication>(*args)
}
