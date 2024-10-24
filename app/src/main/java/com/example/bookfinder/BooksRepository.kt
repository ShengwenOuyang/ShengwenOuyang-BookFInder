package com.example.bookfinder

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BooksRepository(private val apiService: BooksApiService) {
    fun searchBooks(query: String, apiKey: String): Flow<List<BookItem>> = flow {
        val response = apiService.searchBooks(query, apiKey)
        emit(response.items ?: emptyList())
    }
}
