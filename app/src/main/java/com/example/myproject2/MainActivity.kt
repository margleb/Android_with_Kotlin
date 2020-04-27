package com.example.myproject2

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
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
        val dpd = DatePickerDialog(this,
            // это записаное лямбдой функция callback
            DatePickerDialog.OnDateSetListener{ view, selectedYear, selectedMonth, selectedDayOfMonth ->
                Toast.makeText(this, "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth ", Toast.LENGTH_SHORT).show()

                // нам нужен + 1 так как месяц начинается с позиции 0, а не с позиции 1
                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                // здесь просто преобразовываем в формат даты
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)

                // может получится, что time будет пустой, поэтому мы указываем !! то что типа доверяем
                // количество минут с 1970 года до выбранной даты
                val selectedDateInMinutes = theDate!!.time / 60000

                // количество минут с 1970 года до текущей даты
                var currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                var currentDateInMinutes = currentDate!!.time / 60000

                // получаем разницу в минутах от выбранной даты до сегодняшнего дня
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                // устанавливаем значение в минутах
                tvAgeInMinutes.setText(differenceInMinutes.toString())

                tvSelectedDate.setText(selectedDate)
            }, year, month, day)


        // число - миллисикунд в одном дне
        // не позволяет выбрать дату из будущего
        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()

    }
}
