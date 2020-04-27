package com.example.myproject2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // получаем id напрямую, получаем view и выполняем его напрямую
        btnDatePicker.setOnClickListener {view -> clickDatePicker(view) }
    }

    fun clickDatePicker(view: View) {

        // получение значения календаря
        val myCalendar = Calendar.getInstance();
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        // date picker
        DatePickerDialog(this,
            // это записаное лямбдой функция callback
            DatePickerDialog.OnDateSetListener{ view, year, month, dayOfMonth -> Toast.makeText(this, "Datepicker works", Toast.LENGTH_SHORT).show()},
            year, month, day).show()

    }
}
