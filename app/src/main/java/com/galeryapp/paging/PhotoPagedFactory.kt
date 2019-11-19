package com.galeryapp.paging

import androidx.paging.DataSource
import com.galeryapp.domain.model.PhotoListItem
import com.galeryapp.domain.repository.FlickrPhotosRepository

class PhotoPagedFactory(private val flickrPhotosRepository: FlickrPhotosRepository) :
        DataSource.Factory<Int, PhotoListItem>() {

    override fun create(): DataSource<Int, PhotoListItem> {
        return PagedPhotosListDatasource(flickrPhotosRepository)
    }

}