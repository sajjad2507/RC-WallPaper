package com.example.rcwallpaper.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.rcwallpaper.FinalWallPaper
import com.example.rcwallpaper.Model.TctModel
import com.example.rcwallpaper.R

class TctAdapter(val requireContext: Context, val theColorTone: ArrayList<TctModel>) :
    RecyclerView.Adapter<TctAdapter.bomViewHolder>() {

    inner class bomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemColor = itemView.findViewById<CardView>(R.id.item_color)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_colortone, parent, false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        val color = theColorTone[position].color

        holder.itemColor.setCardBackgroundColor(Color.parseColor(color!!))

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext, FinalWallPaper::class.java)
            intent.putExtra("link", theColorTone[position].link)

            requireContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return theColorTone.size
    }

}