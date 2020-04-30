package com.example.myproject2

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.dialog_custom.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Пример SnackBar
        image_button.setOnClickListener {view ->
            Snackbar.make(view, "You have clicked image button.", Snackbar.LENGTH_SHORT).show()
        }
        // Пример AlertDialog
        btn_alert_dialog.setOnClickListener{view ->
            // Launch Alert Dialog
            alertDialogFunction()
        }
        // Пример Custom Dialog Button
        btn_custom_dialog.setOnClickListener{
            customDialogFunction()
        }
        // Пример Progress Dialog Button
        btn_custom_progress_dialog.setOnClickListener{
            customProgressDialogFunction()
        }
    }

    /**
     * Метод демонстрирующий alertDialog
     */
    private fun alertDialogFunction() {
        val builder = AlertDialog.Builder(this)
        // заголовок Alert Dialog
        builder.setTitle("Alert")
        // cообщение Alert Dialog
        builder.setMessage("This is Alert Dialog. Which is used to show alerts in our app.")
        builder.setIcon(android.R.drawable.ic_dialog_alert) // иконка

        // при нажатии на кнопку "да"
        builder.setPositiveButton("Yes") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked yes", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss() // Диалоговое окно будет завершено
        }
        // при нажатии на кнопку "отмена"
        builder.setNeutralButton("Cancel") { dialogInterface, which ->
            Toast.makeText(
                applicationContext,
                "clicked cancel\n operation cancel",
                Toast.LENGTH_LONG
            ).show()
            dialogInterface.dismiss() // Диалоговое окно будет завершено
        }
        // отмена (закрытие) диалогового окна
        builder.setNegativeButton("No") { dialogInterface, which ->
            Toast.makeText(applicationContext, "clicked No", Toast.LENGTH_LONG).show()
            dialogInterface.dismiss()  // Диалоговое окно будет завершено
        }
        // Создание диалогового окна
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false) // Не позволяет закрыть диалоговое окно при нажатии вне его области
        alertDialog.show()  // отобразить диалоговое окно в интерфейсе
    }

    /**
     * Метод для создания кастомного диалогого окна
     */
    private fun customDialogFunction() {
        val customDialog = Dialog(this)
        // устанавливается layout для диалогового окна
        customDialog.setContentView(R.layout.dialog_custom)
        customDialog.tv_submit.setOnClickListener(View.OnClickListener {
            // applicationContext - более безопасный подход, нежели использование this
            Toast.makeText(applicationContext, "clicked submit", Toast.LENGTH_LONG).show()
            customDialog.dismiss() //  Диалоговое окно будет завершено
        })
        customDialog.tv_cancel.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked cancel", Toast.LENGTH_LONG).show()
            customDialog.dismiss()
        })
        customDialog.show() // отобразить диалоговое окно в интерфейсе
    }

    /**
     * Метод, используемый для показа Custom Progress Dialog.
     */
    private fun customProgressDialogFunction() {
        val customProgressDialog = Dialog(this)
        // устанавливаем контент
        customProgressDialog.setContentView(R.layout.dialog_custom_progress)
        //Start the dialog and display it on screen.
        customProgressDialog.show()
    }
}
