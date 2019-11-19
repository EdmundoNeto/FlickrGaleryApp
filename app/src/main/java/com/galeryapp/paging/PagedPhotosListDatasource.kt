package com.galeryapp.paging

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import com.galeryapp.domain.model.PhotoListItem
import com.galeryapp.domain.repository.FlickrPhotosRepository

class PagedPhotosListDatasource(private val flickrPhotosRepository: FlickrPhotosRepository) :
        PageKeyedDataSource<Int, PhotoListItem>() {

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, PhotoListItem>) {
        flickrPhotosRepository.getPhotosList(1)
                .subscribe(
                        { callback.onResult(it, null, 2) },
                        { it.printStackTrace() }
                )
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoListItem>) {
        flickrPhotosRepository.getPhotosList(params.key)
                .subscribe(
                        { callback.onResult(it, params.key + 1) },
                        { it.printStackTrace() }
                )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, PhotoListItem>) {}
}