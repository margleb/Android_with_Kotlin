package com.example.myproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        val questionsList = Constants.getQuestions()
        Log.i("QuestionsSize", "${questionsList.size}")

        val currentPosition = 1
        val question: Question? = questionsList[currentPosition - 1]
        // устанавливаем текущую полизицию прогресс-бара
        progressBar.progress = currentPosition
        // устанавилваем значение progress bar текста
        tv_progress.text = "$currentPosition " + "/" + progressBar.max
        // устанавливаем текущий вопрос
        tv_question.text = question!!.question
        // устанавливаем текущее изображение флага
        iv_image.setImageResource(question.image)
        // устанавливаем значение текстов
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }
}
