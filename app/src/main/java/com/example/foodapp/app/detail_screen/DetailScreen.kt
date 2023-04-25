package com.example.foodapp.app.detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.foodapp.app.BaseFragment
import com.example.foodapp.databinding.DetailScreenBinding


class DetailScreen : BaseFragment() {

    private lateinit var binding: DetailScreenBinding
    private var image = ""
    private var name = ""
    private var description = ""
    private var latitude = ""
    private var longitude = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetailScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun ui() {
        getExtrasId()
        addListener()
        Glide.with(this)
            .load(image)
            .centerInside()
            .into(binding.image)
        binding.txtName.text = name
        binding.txtDescription.text = description
    }

    private fun getExtrasId() {
        image = DetailScreenArgs.fromBundle(requireArguments()).image
        name = DetailScreenArgs.fromBundle(requireArguments()).name
        description = DetailScreenArgs.fromBundle(requireArguments()).description
        latitude = DetailScreenArgs.fromBundle(requireArguments()).latitude
        longitude = DetailScreenArgs.fromBundle(requireArguments()).longitude
    }

    private fun addListener() {
        binding.fab.setOnClickListener {
            val action =
                DetailScreenDirections.actionDetailScreenToMapScreen(latitude, longitude, name)
            findNavController().navigate(action)
        }
    }

}