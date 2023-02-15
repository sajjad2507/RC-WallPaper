package com.example.rcwallpaper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rcwallpaper.FinalWallPaper
import com.example.rcwallpaper.R
import com.makeramen.roundedimageview.RoundedImageView

class DownloadAdapter(val requireContext: Context, val imageList: ArrayList<String>) :
    RecyclerView.Adapter<DownloadAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cat_wallpaper = itemView.findViewById<RoundedImageView>(R.id.cat_wallpaper)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_wallpaper, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(imageList[position]).into(holder.cat_wallpaper)

    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}