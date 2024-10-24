package com.example.bookfinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BooksViewModel(private val repository: BooksRepository) : ViewModel() {
    private val _books = MutableStateFlow<List<BookItem>>(emptyList())
    val books: StateFlow<List<BookItem>> = _books

    fun searchBooks(query: String, apiKey: String) {
        viewModelScope.launch {
            repository.searchBooks(query, apiKey).collect { bookList ->
                _books.value = bookList
            }
        }
    }
}
