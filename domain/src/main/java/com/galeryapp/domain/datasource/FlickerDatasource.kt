package com.galeryapp.domain.datasource

import com.galeryapp.domain.model.FlickrPhotos
import com.galeryapp.domain.model.SinglePhoto
import com.galeryapp.domain.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickerDatasource {
    @GET("/services/rest/")
    fun getPhotosList(
            @Query("method") method: String = SEARCH_METHOD,
            @Query("api_key") api_key: String = API_KEY,
            @Query("tags") tags: String = API_TAG,
            @Query("page") page: Int,
            @Query("format") format: String = API_FORMAT,
            @Query("nojsoncallback") nojsoncallback: Int = API_NOJSONCALLBAKC,
            @Query("per_page") per_page: Int = API_PER_PAGE
    ): Observable<FlickrPhotos>

    @GET("/services/rest/")
    fun getSinglePhoto(
            @Query("method") method: String = GETSIZE_METHOD,
            @Query("api_key") api_key: String = API_KEY,
            @Query("photo_id") photo_id: String,
            @Query("format") format: String = API_FORMAT,
            @Query("nojsoncallback") nojsoncallback: Int = API_NOJSONCALLBAKC
    ): Observable<SinglePhoto>
}