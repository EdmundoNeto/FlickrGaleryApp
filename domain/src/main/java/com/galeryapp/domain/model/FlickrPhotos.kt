package com.galeryapp.domain.model

data class FlickrPhotos(
        val photos: Photos,
        val stat: String
)

data class Photos(
        val page: Int,
        val pages: Int,
        val perpage: Int,
        val photo: List<Photo>,
        val total: String
)

data class Photo(
    val farm: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String
)

data class SinglePhoto(
    val sizes: PhotoSizes,
    val stat: String
)

data class PhotoSizes(
    val canblog: Int,
    val candownload: Int,
    val canprint: Int,
    val size: List<PhotoSizeItems>
)

data class PhotoSizeItems(
    val height: Int,
    val label: String,
    val media: String,
    val source: String,
    val url: String,
    val width: Int
)