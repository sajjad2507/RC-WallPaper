package com.example.rcwallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rcwallpaper.Model.CatWallpaperModel
import com.example.rcwallpaper.adapters.WallpaperAdapter
import com.example.rcwallpaper.databinding.ActivityCatBinding
import com.google.firebase.firestore.FirebaseFirestore

class CatActivity : AppCompatActivity() {

    lateinit var binding: ActivityCatBinding
    lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatBinding.inflate(layoutInflater)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        setContentView(binding.root)

        db = FirebaseFirestore.getInstance()
        val uid = intent.getStringExtra("uid")
        val name = intent.getStringExtra("name")

        db.collection("categories").document(uid!!).collection("wallpaper")
            .addSnapshotListener { value, error ->
                val theCatWallpapers = arrayListOf<CatWallpaperModel>()
                val wallpapers = value?.toObjects(CatWallpaperModel::class.java)
                theCatWallpapers.addAll(wallpapers!!)

                binding.wallpaperName.text = name.toString()
                binding.wallpaperCount.text = theCatWallpapers.size.toString() + " wallpaper available"

                    binding.wallpaperRcv.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                binding.wallpaperRcv.adapter = WallpaperAdapter(this, theCatWallpapers)


            }
    }
}