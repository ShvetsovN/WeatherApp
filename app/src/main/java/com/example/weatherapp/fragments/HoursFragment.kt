package com.example.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.adapters.WeatherAdapter
import com.example.weatherapp.adapters.WeatherModel
import com.example.weatherapp.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {

    private lateinit var binding: FragmentHoursBinding
    private lateinit var adapter: WeatherAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHoursBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() = with(binding) {
        rvHours.layoutManager = LinearLayoutManager(activity)
        adapter = WeatherAdapter()
        rvHours.adapter = adapter
        val list = listOf(
            WeatherModel(
                city = "",time = "12:00",
                condition = "Sunny",currentTemp = "25°C",
                "","","",""
            ),
            WeatherModel(
                city = "", time = "13:00",
                condition = "Sunny", currentTemp = "27°C",
                "","","",""
            ),
            WeatherModel(
                city = "", time = "14:00",
                condition = "Sunny", currentTemp = "29°C",
                "", "", "",""
            )
        )
        adapter.submitList(list)
    }

    companion object {

        @JvmStatic
        fun newInstance() = HoursFragment()

    }
}