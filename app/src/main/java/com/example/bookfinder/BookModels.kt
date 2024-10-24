package com.example.bookfinder

import com.squareup.moshi.Json

data class BooksResponse(
    @Json(name = "items") val items: List<BookItem>?
)

data class BookItem(
    @Json(name = "volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @Json(name = "title") val title: String,
    @Json(name = "authors") val authors: List<String>?,
    @Json(name = "imageLinks") val imageLinks: ImageLinks?
)

data class ImageLinks(
    @Json(name = "thumbnail") val thumbnail: String
)
