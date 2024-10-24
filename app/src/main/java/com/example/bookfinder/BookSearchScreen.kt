package com.example.bookfinder.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.bookfinder.BookItem
import com.example.bookfinder.BooksViewModel

@Composable
fun BookSearchScreen(viewModel: BooksViewModel, apiKey: String) {
    var query by remember { mutableStateOf("") }

    Column {
        SearchBar(query, onQueryChanged = { newQuery ->
            query = newQuery
            viewModel.searchBooks(query, apiKey)
        })

        val books = viewModel.books.collectAsState().value

        BookList(books = books)
    }
}

@Composable
fun SearchBar(query: String, onQueryChanged: (String) -> Unit) {
    // Basic search bar UI
}

@Composable
fun BookList(books: List<BookItem>) {
    LazyColumn {
        items(books) { book ->
            BookItemView(book)
        }
    }
}

@Composable
fun BookItemView(book: BookItem) {
    Row(modifier = Modifier.padding(8.dp)) {
        Image(
            painter = rememberImagePainter(book.volumeInfo.imageLinks?.thumbnail),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = book.volumeInfo.title)
            Text(text = book.volumeInfo.authors?.joinToString(", ") ?: "Unknown Author")
        }
    }
}
