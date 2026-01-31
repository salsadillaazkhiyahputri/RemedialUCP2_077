package com.example.remedialucp2_077.room

import androidx.room.Entity

@Entity(primaryKeys = ["bookId", "authorId"])
data class BookAuthor(
    val bookId: Long,
    val authorId: Long
)
