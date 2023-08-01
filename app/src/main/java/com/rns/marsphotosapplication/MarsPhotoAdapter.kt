package com.rns.marsphotosapplication

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.rns.marsphotosapplication.databinding.ImageItemLayoutBinding
import com.rns.marsphotosapplication.network.MarsPhotoItem

class MarsPhotoAdapter : ListAdapter<MarsPhotoItem, MarsPhotoAdapter.MarsViewHolder>(DiffCallBack) {

    class MarsViewHolder(private var binding: ImageItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(marsPhoto: MarsPhotoItem) {
            binding.photo = marsPhoto
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(ImageItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<MarsPhotoItem>(){
        override fun areItemsTheSame(oldItem: MarsPhotoItem, newItem: MarsPhotoItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhotoItem, newItem: MarsPhotoItem): Boolean {
            return oldItem.imgSrc == newItem.imgSrc
        }

    }
}