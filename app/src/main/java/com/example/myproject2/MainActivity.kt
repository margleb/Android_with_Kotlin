package com.example.myproject2

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_execute.setOnClickListener{
            ExecuteAsyncTask("Background task executed successfully.").execute()
        }
    }
    // Внутренний класс помеченный как inner, может иметь доступ до членов своего внешнего класса
    // Внутренние классы содержат ссылки на обьекты своего внешнего класса
    // Ресурс: https://kotlinlang.org/docs/reference/nested-classes.html
    // Данный класс используется для выполнения задач на "заднем фоне"
    // Для этого он расширяется классом AsyncTask
    private inner class ExecuteAsyncTask(val value: String) : AsyncTask<Any, Void, String>() {

        var customProgressDialog: Dialog? = null

        // Данная функция отвечает за задачи, которые мы хотим выполнить перед тем как начнется выполнение на "заднем фоне"
        // В данном случае, мы хотим показать progress dialog для пользователя, который не вызывет зависания UI, но выполнит что либо на "заднем фоне"
        override fun onPreExecute() {
            super.onPreExecute()
            showProgressDialog()
        }

        // Данный метод используется для выполнения каких либо задач на "заднем фоне"
        override fun doInBackground(vararg params: Any?): String {
           // TODO: здесь можно написать любой код, который позволит выполнить задачу без зависания пользовательского интерфеса
           // это просто цикл, имитирующий выполнение асинхронного кода
           for(i in 1..100000) {
               Log.e("i: ", "" + 1)
           }
           // Возращаем сообщение посредством метода onPostExecude, уведомляющее о завершении выполнения асинхронного кода
           return value
        }
        // Данный метод вызовится после заверешения выполения асинхронного кода на заднем фоне
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            cancelProgressDialog()
            Toast.makeText(this@MainActivity, result, Toast.LENGTH_SHORT).show()
        }

        private fun cancelProgressDialog() {
            if (customProgressDialog != null) {
                customProgressDialog!!.dismiss()
                customProgressDialog = null
            }
        }

        // Метод используемы для отображения Диалоговго окна прогресса
        private fun showProgressDialog() {
            customProgressDialog = Dialog(this@MainActivity)
            /*Устанавливаем слой, которым будет расширен наш основной слой */
            customProgressDialog!!.setContentView(R.layout.dialog_custom_progress)
            /* Отображаем данное окно */
            customProgressDialog!!.show()
        }

    }

}
