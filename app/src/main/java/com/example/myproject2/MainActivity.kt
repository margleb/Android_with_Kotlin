package com.example.myproject2

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // класс, содержащий константы
    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private const val FINE_LOCATION_PERMISSION_CODE = 2
        private const val CAMERA_AND_FINE_LOCATION_PERMISSION_CODE = 12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCameraPermission.setOnClickListener{
            if (
                ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
            )
            {
                Toast.makeText(this, "You already have access for camera and location", Toast.LENGTH_SHORT).show()
            }
            else
            {
                // Request Permission
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION), CAMERA_AND_FINE_LOCATION_PERMISSION_CODE)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_AND_FINE_LOCATION_PERMISSION_CODE) {
            if(grantResults.isNotEmpty() && (grantResults[0] == PackageManager.PERMISSION_DENIED || grantResults[1] == PackageManager.PERMISSION_DENIED)) {
                Toast.makeText(this, "You need permission for camera and location!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You already has a permission for location and camera", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
