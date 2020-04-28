package com.example.myproject2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var lastNumeric:Boolean = false
    var lastDot:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // используется атрибут в XML onClick
    fun onDigit(view: View) {
        tvInput.append((view as Button).text) // добавляем текст с кнопки
        lastNumeric = true
        // проверяет, содержится ли в поле уже какоей либо значение
        // if(tvInput.text.contains("1")) tvInput.text = "Haha"
    }

    fun onClear(view: View) {
        tvInput.text = ""
        lastNumeric = false
        lastDot = false
    }

    fun onDecimalPoint(view:View) {
        // если значение до было номером
        // и не было точкой до этого
        if(lastNumeric && !lastDot) {
            tvInput.append(".")
            lastNumeric = false
            lastDot = true
        }
    }

    fun onOperator(view: View) {
        if(lastNumeric && !isOperatorAdded(tvInput.text.toString())) {
            tvInput.append((view as Button).text)
            lastNumeric = false
            lastDot = false
        }
    }

    private fun isOperatorAdded(value:String) : Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }

}
