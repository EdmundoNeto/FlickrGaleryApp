package com.galeryapp.paging

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.galeryapp.domain.model.PhotoListItem

class PhotoPagedListAdapter(private val listener : ItemClickedLister) : PagedListAdapter<PhotoListItem, PhotosViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder = PhotosViewHolder.create(parent)

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photoSizeItem = getItem(position)
        holder.binding.photoItems = photoSizeItem
        holder.itemView.setOnClickListener { listener.onItemClicked(photoSizeItem) }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<PhotoListItem>() {
            override fun areItemsTheSame(oldItem: PhotoListItem, newItem: PhotoListItem):
                    Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PhotoListItem, newItem: PhotoListItem):
                    Boolean = oldItem.urlLargeSquare == newItem.urlLargeSquare
        }
    }

    interface ItemClickedLister {
        fun onItemClicked( photoListItem: PhotoListItem? )
    }

}