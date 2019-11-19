package com.galeryapp.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.galeryapp.commons.BaseActivity
import com.galeryapp.databinding.ActivityMainBinding
import com.galeryapp.domain.model.PhotoListItem
import com.galeryapp.paging.PhotoPagedListAdapter

class MainActivity : BaseActivity(), PhotoPagedListAdapter.ItemClickedLister  {

    private lateinit var binding : ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()
        setupRecycler()

    }

    private fun setupRecycler() {
        binding.main.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.main.itemAnimator = DefaultItemAnimator()

        val adapter = PhotoPagedListAdapter(this)
        binding.main.adapter = adapter

        viewModel.listLiveData!!.observe(this, Observer {
            adapter.submitList(it)
        })

    }

    override fun onItemClicked(photoListItem: PhotoListItem?) {
        photoListItem?.let {  PhotoDetailFragment.getDialog(it).show(supportFragmentManager, "") }
    }

}
