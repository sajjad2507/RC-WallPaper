package com.example.rcwallpaper.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rcwallpaper.CatActivity
import com.example.rcwallpaper.Model.CatModel
import com.example.rcwallpaper.R

class CatAdapter(val requireContext: Context, val theCategories: ArrayList<CatModel>) :
    RecyclerView.Adapter<CatAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.cat_name)
        val cat_img = itemView.findViewById<ImageView>(R.id.cat_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_cat, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        Glide.with(requireContext).load(theCategories[position].link).into(holder.cat_img)
        holder.name.text = theCategories[position].name

        holder.itemView.setOnClickListener {

            val intent = Intent(requireContext, CatActivity::class.java)
            intent.putExtra("uid", theCategories[position].id)
            intent.putExtra("name", theCategories[position].name)

            requireContext.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return theCategories.size
    }

}