package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // используется атрибут в XML onClick
    fun onDigit(view: View) {
        tvInput.append((view as Button).text) // добавляем текст с кнопки
    }

    fun onClear(view: View) {
        tvInput.text = ""
    }

}
