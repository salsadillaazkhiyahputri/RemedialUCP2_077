package com.example.remedialucp2_077.database


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.remedialucp2_077.room.AuditDao
import com.example.remedialucp2_077.room.BookDao
import com.example.remedialucp2_077.room.CategoryDao
import com.example.remedialucp2_077.room.Book
import com.example.remedialucp2_077.room.BookCopy
import com.example.remedialucp2_077.room.Author
import com.example.remedialucp2_077.room.BookAuthor
import com.example.remedialucp2_077.room.Category
import com.example.remedialucp2_077.room.BookCategory
import com.example.remedialucp2_077.room.AuditLog


@Database(
    entities = [
        Book::class,
        BookCopy::class,
        Author::class,
        BookAuthor::class,
        Category::class,
        BookCategory::class,
        AuditLog::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
    abstract fun categoryDao(): CategoryDao
    abstract fun auditDao(): AuditDao
}
