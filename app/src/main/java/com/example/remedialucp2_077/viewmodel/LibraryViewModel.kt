package com.example.remedialucp2_077.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_077.repository.LibraryRepository
import com.example.remedialucp2_077.room.Book
import kotlinx.coroutines.launch

class LibraryViewModel(
    private val repo: LibraryRepository
) : ViewModel() {

    private val _books = mutableStateListOf<Book>()
    val books: List<Book> = _books

    fun loadBooks() {
        viewModelScope.launch {
            _books.clear()
            _books.addAll(repo.getAllBooks())
        }
    }

    fun addBook(title: String) {
        viewModelScope.launch {
            repo.addBook(title)
            loadBooks()
        }
    }

    fun deleteCategory(id: Long) {
        viewModelScope.launch {
            try {
                repo.deleteCategory(id)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}