package com.galeryapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.galeryapp.domain.model.PhotoListItem
import com.galeryapp.domain.repository.FlickrPhotosRepository
import com.galeryapp.paging.PhotoPagedFactory

class MainViewModel: ViewModel(){

    var listLiveData: LiveData<PagedList<PhotoListItem>>? = null

    private val config : PagedList.Config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(5)
            .build()

    init {
        listLiveData = LivePagedListBuilder<Int, PhotoListItem>(PhotoPagedFactory(FlickrPhotosRepository), config).build()
    }

}