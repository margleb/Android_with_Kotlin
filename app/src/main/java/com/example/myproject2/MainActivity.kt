package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get referrence to button;
        val btn_click_me = findViewById(R.id.btn_click_me) as Button
        val myTextView = findViewById(R.id.textView) as TextView;
        var timeClicked = 0;
        // set on-click listen
        btn_click_me.setOnClickListener {
            timeClicked = timeClicked + 1;
            myTextView.text = timeClicked.toString();
            Toast.makeText(this@MainActivity, "Hi Denis.", Toast.LENGTH_SHORT).show();
        }
    }
}
