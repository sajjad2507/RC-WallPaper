package com.example.rcwallpaper.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rcwallpaper.Model.BomModel
import com.example.rcwallpaper.Model.CatModel
import com.example.rcwallpaper.Model.TctModel
import com.example.rcwallpaper.adapters.BomAdapter
import com.example.rcwallpaper.adapters.CatAdapter
import com.example.rcwallpaper.adapters.TctAdapter
import com.example.rcwallpaper.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var db: FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        db = FirebaseFirestore.getInstance()

        db.collection("bestofthemonth").addSnapshotListener { value, error ->
            val listBestOfTheMonth = arrayListOf<BomModel>()
            val data = value?.toObjects(BomModel::class.java)
            listBestOfTheMonth.addAll(data!!)

            binding.rcvBom.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvBom.adapter = BomAdapter(requireContext(), listBestOfTheMonth)
        }

        db.collection("thecolortone").addSnapshotListener { value, error ->
            val theColorTone = arrayListOf<TctModel>()
            val colors = value?.toObjects(TctModel::class.java)
            theColorTone.addAll(colors!!)

            binding.rcvTct.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            binding.rcvTct.adapter = TctAdapter(requireContext(), theColorTone)
        }


        db.collection("categories").addSnapshotListener { value, error ->
            val theCategories = arrayListOf<CatModel>()
            val categories = value?.toObjects(CatModel::class.java)
            theCategories.addAll(categories!!)

            binding.rcvCat.layoutManager =
                GridLayoutManager(requireContext(), 2)
            binding.rcvCat.adapter = CatAdapter(requireContext(), theCategories)
        }

        return binding.root
    }
}