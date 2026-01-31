package com.example.remedialucp2_077.repository

import androidx.room.Transaction
import com.example.remedialucp2_077.database.AppDatabase
import com.example.remedialucp2_077.room.AuditLog
import com.example.remedialucp2_077.room.Book

class LibraryRepository(private val db: AppDatabase) {

    fun validateBook(title: String) {
        require(title.isNotBlank()) { "Judul tidak boleh kosong" }
    }

    suspend fun addBook(title: String) {
        validateBook(title)
        db.bookDao().insert(Book(title = title))
    }

    suspend fun getAllBooks(): List<Book> {
        return db.bookDao().getAll()
    }

    @Transaction
    suspend fun deleteCategory(categoryId: Long) {
        val books = db.categoryDao().getBooksRecursive(categoryId)


        val masihDipinjam = books.any { false }

        if (masihDipinjam) {
            throw Exception("Masih ada buku dipinjam")
        }

        db.categoryDao().softDeleteCategory(categoryId)

        db.auditDao().insert(
            AuditLog(
                tableName = "Category",
                beforeData = "ACTIVE",
                afterData = "DELETED"
            )
        )
    }
}