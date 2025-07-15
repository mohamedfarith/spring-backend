package com.learning.book_store_api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

    @GetMapping
    fun getAllBooks() = bookService.getAllBooks()

    @GetMapping("/{id}")
    fun getBookById(mId: Long): ResponseEntity<Book> {
        val book = bookService.getBookById(mId)
        return if (book != null) ResponseEntity.ok(book)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createBook(@RequestBody book: Book): Book = bookService.createBook(book)

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: Book): ResponseEntity<Book> {
        val updated = bookService.updateBook(id, book)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }
    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Void> {
        bookService.deleteBook(id)
        return ResponseEntity.noContent().build()
    }
}