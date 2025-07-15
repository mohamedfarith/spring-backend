package com.learning.book_store_api

import org.springframework.stereotype.Service

@Service
class BookService(private val bookRepository: BookRepository) {

    fun getAllBooks(): List<Book> = bookRepository.findAll()

    fun getBookById(id: Long): Book? = bookRepository.findById(id).orElse(null)

    fun createBook(book: Book): Book = bookRepository.save(book)

    fun updateBook(id: Long, updated: Book): Book? {
        return bookRepository.findById(id).map {
            val updatedBook = Book(
                title = updated.title,
                author = updated.author,
                price = updated.price
            )
            bookRepository.save(updatedBook)
        }?.orElse(null)
    }

    fun deleteBook(id: Long) = bookRepository.deleteById(id)
}