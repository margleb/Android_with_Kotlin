package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // устанавливаем толщину кисти в соответствии с размером экрана
        drawing_view.setSizeForBrush(20.toFloat())
    }
}
