package com.galeryapp.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.galeryapp.databinding.ItemFlickrViewholderBinding

class PhotosViewHolder(val binding: ItemFlickrViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun create (parent : ViewGroup) : PhotosViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return PhotosViewHolder(ItemFlickrViewholderBinding.inflate(inflater))
        }
    }

}