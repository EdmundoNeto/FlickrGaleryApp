package com.galeryapp.domain.model

import java.io.Serializable


data class PhotoListItem (
        var id: String,
        var urlLargeSquare: String? = null,
        var urlLarge: String? = null
): Serializable {
    companion object {
        fun fromSinglePhoto(singlePhoto: SinglePhoto): PhotoListItem {

            val largeSquare  = singlePhoto.sizes.size.filter { it.label == "Large Square" }
            val large = singlePhoto.sizes.size.filter { it.label == "Large" }
            return PhotoListItem(largeSquare.first().url,
                    largeSquare.first().source.orEmpty(),
                    large.first().source.orEmpty())
        }
    }
}
