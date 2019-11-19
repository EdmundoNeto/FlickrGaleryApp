package com.galeryapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.galeryapp.databinding.FragmentPhotoDetailBinding
import com.galeryapp.domain.model.PhotoListItem

class PhotoDetailFragment : DialogFragment() {

    companion object {
        const val EXTRA_PHOTO: String = "photo_detail_to_show"

        fun getDialog(photoListItem: PhotoListItem): PhotoDetailFragment {
            val dialog = PhotoDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(EXTRA_PHOTO, photoListItem)
            dialog.arguments = arguments
            dialog.setStyle(STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_NoActionBar)

            return dialog
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog?.setCanceledOnTouchOutside(true)

        val detailFragmentBinding = FragmentPhotoDetailBinding.inflate(inflater, container, false)
        val photoListItem = arguments?.getSerializable(EXTRA_PHOTO) as PhotoListItem?

        detailFragmentBinding.photoListItem = photoListItem

        return detailFragmentBinding.root
    }

}