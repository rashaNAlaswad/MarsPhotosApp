package com.rns.marsphotosapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.rns.marsphotosapplication.MarsPhotoAdapter
import com.rns.marsphotosapplication.R
import com.rns.marsphotosapplication.databinding.FragmentMarsPhotosBinding
import com.rns.marsphotosapplication.viewModel.MarsPhotosViewModel

class MarsPhotosFragment : Fragment() {

    private val viewModel: MarsPhotosViewModel by viewModels()
    private lateinit var binding: FragmentMarsPhotosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mars_photos, container, false)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.marsRecyclerView.adapter = MarsPhotoAdapter()

        return binding.root
    }
}