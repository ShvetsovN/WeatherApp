package com.example.weatherapp.fragments

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.weatherapp.adapters.VpAdapter
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.isPermissionGranted
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance(),
    )
    private val tList = listOf(
        "Hours", "Days"
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>
    private val binding: FragmentMainBinding by lazy {
        FragmentMainBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()
        init()
    }

    private fun init() = with(binding) {
        val adapter = VpAdapter(activity as AppCompatActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp){ tab, pos ->
            tab.text = tList[pos]
        }.attach()
    }

    private fun permissionListener() {
        pLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()
        }
    }

    private fun checkPermission() {
        if(!isPermissionGranted(Manifest.permission.ACCESS_FINE_LOCATION)) {
            permissionListener()
            pLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}
