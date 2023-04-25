package com.example.foodapp.app.map_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.foodapp.R
import com.example.foodapp.app.BaseFragment
import com.example.foodapp.databinding.MapScreenBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MapScreen : BaseFragment(), OnMapReadyCallback {

    private lateinit var binding: MapScreenBinding
    private lateinit var map: GoogleMap

    private var name = ""
    private var latitude = ""
    private var longitude = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MapScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun ui() {
        createMapFragment()
        getExtrasId()
        zoom()
    }

    private fun createMapFragment() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        this.map = map
    }

    private fun getExtrasId() {
        latitude = MapScreenArgs.fromBundle(requireArguments()).latitude
        longitude = MapScreenArgs.fromBundle(requireArguments()).longitude
        name = MapScreenArgs.fromBundle(requireArguments()).name
    }

    private fun zoom() {
        lifecycleScope.launch {
            delay(300L)

            val ubication = LatLng(latitude.toDouble(), longitude.toDouble())
            val marker = MarkerOptions().position(ubication).title(name)
            map.addMarker(marker)
            map.animateCamera(
                CameraUpdateFactory.newLatLngZoom(ubication, 10f), 2500, null
            )
        }
    }
}