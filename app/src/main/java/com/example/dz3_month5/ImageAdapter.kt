package com.example.dz3_month5

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.*
import coil.load
import com.example.dz3_month5.databinding.ActivityMainBinding
import com.example.dz3_month5.databinding.ItemImageBinding

class ImageAdapter(var list: ArrayList<ImageModel>) : Adapter<ImageAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    @SuppressLint("NotifyDataSetChanged")
    fun addImage(imageModel: ArrayList<ImageModel>) {
        list.addAll(imageModel)
        notifyDataSetChanged()
    }

    fun cleanImage() {
        list.clear()
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size

    class ImageViewHolder(var binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(imageModel: ImageModel) {
            binding.imageV.load(imageModel.largeImageURL)
        }
    }
}