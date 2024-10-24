package com.example.bookfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.bookfinder.ui.BookSearchScreen
import com.example.bookfinder.ui.theme.BookFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: BooksViewModel by viewModels()  // ViewModel instance
            BookFinderTheme {
                BookSearchScreen(viewModel = viewModel, apiKey = "AIzaSyCol5k7BDLKTL6Dj27tbDKL6RhJJSrlHXQ")
            }
        }
    }
}
