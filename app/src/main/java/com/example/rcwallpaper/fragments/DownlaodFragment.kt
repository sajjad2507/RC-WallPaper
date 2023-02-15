package com.example.rcwallpaper.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rcwallpaper.adapters.DownloadAdapter
import com.example.rcwallpaper.databinding.FragmentDownlaodBinding
import java.io.File

class DownlaodFragment : Fragment() {

    lateinit var binding: FragmentDownlaodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDownlaodBinding.inflate(layoutInflater, container, false)

        val allFiles: Array<File>
        val imageList = arrayListOf<String>()

        val targetPath =
            Environment.getExternalStorageDirectory().absolutePath + "/Pictures/RC Wallpaper"

        val targetFile = File(targetPath)
        allFiles = targetFile.listFiles()!!

        for (data in allFiles) {
            imageList.add(data.absolutePath)
        }

        binding.rcvDownload.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.rcvDownload.adapter = DownloadAdapter(requireContext(), imageList)


        return binding.root
    }
}