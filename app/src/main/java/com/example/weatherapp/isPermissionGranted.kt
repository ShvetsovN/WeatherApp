package com.example.weatherapp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.isPermissionGranted(permissionName: String): Boolean {
    return ContextCompat.checkSelfPermission(
        activity as AppCompatActivity, permissionName
    ) == PackageManager.PERMISSION_GRANTED
}