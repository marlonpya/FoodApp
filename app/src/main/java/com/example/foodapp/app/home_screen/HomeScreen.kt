package com.example.foodapp.app.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.app.BaseFragment
import com.example.foodapp.app.model.FoodListModel
import com.example.foodapp.databinding.HomeScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeScreen() : BaseFragment() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: FoodListAdapter
    private lateinit var binding: HomeScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun ui() {
        initAdapter()
        addObserver()
        callFoods()
    }

    private fun initAdapter() {
        adapter = FoodListAdapter {
            val action = HomeScreenDirections.actionHomeScreenFragmentToDetailScreen(
                it.image,
                it.name,
                it.description,
                it.latitude,
                it.longitude
            )
            findNavController().navigate(action)
        }
        with(binding.rcvFoods) {
            adapter = this@HomeScreen.adapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
        }
        binding.swipe.isEnabled = false
    }

    private fun addObserver() {
        viewModel.foodMutableLiveData.observe(this, Observer(::addFoods))
        viewModel.loadLD.observe(this, Observer(::onAddLoad))
        viewModel.messageLD.observe(this, Observer(::showError))
    }

    private fun callFoods() {
        viewModel.callGetFoods()
    }

    private fun addFoods(foods: List<FoodListModel>) {
        adapter.setData(foods)
        adapter.notifyDataSetChanged()
    }

    private fun onAddLoad(pbStatus: Boolean) {
        binding.swipe.isEnabled = pbStatus
        binding.swipe.isRefreshing = pbStatus
    }

    override fun showLoading() {
        binding.swipe.isRefreshing = true
    }

    override fun hideLoading() {
        binding.swipe.isRefreshing = false
    }

    private fun showError(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}
