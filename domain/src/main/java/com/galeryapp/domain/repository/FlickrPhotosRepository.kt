package com.galeryapp.domain.repository

import com.galeryapp.domain.model.PhotoListItem
import com.galeryapp.domain.remote.flickrRetrofit
import io.reactivex.Observable

object FlickrPhotosRepository {

    fun getPhotosList(page: Int) =
            flickrRetrofit.getPhotosList(page = page)
                    .flatMap { Observable.fromIterable(it.photos.photo) }
                    .flatMap { flickrRetrofit.getSinglePhoto(photo_id = it.id) }
                    .flatMap { Observable.just(PhotoListItem.fromSinglePhoto(it)) }
                    .toList()
}