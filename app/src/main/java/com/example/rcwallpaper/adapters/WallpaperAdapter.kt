package com.example.rcwallpaper.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rcwallpaper.CatActivity
import com.example.rcwallpaper.FinalWallPaper
import com.example.rcwallpaper.Model.CatWallpaperModel
import com.example.rcwallpaper.R
import com.makeramen.roundedimageview.RoundedImageView

class WallpaperAdapter(val requireContext: Context, val theCatWallpaper: ArrayList<CatWallpaperModel>) :
    RecyclerView.Adapter<WallpaperAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cat_wallpaper = itemView.findViewById<RoundedImageView>(R.id.cat_wallpaper)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_wallpaper, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {

        Glide.with(requireContext).load(theCatWallpaper[position].link).into(holder.cat_wallpaper)

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, FinalWallPaper::class.java)
            intent.putExtra("link", theCatWallpaper[position].link)

            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return theCatWallpaper.size
    }

}