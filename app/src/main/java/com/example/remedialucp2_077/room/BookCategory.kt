package com.example.remedialucp2_077.room

import androidx.room.Entity

@Entity(primaryKeys = ["bookId", "categoryId"])
data class BookCategory(
    val bookId: Long,
    val categoryId: Long
)
