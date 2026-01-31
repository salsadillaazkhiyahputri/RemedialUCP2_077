package com.example.remedialucp2_077.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String
)