package com.example.myproject2

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    // текущая позиция вопроса
    private var mCurrentPosition:Int = 1
    // массив вопросов
    private var mQuestionsList:ArrayList<Question>? = null
    // выбранная позиция вопроса
    private var mSelectedOptionPosition:Int = 0
    // количество верных ответов
    private var mCorrectAnswers: Int = 0
    // имя пользователя
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        // получаем имя из mainActivity
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)
    }

    private fun setQuestion() {
        // не обязательно использовать get функцию
        val question = mQuestionsList!![mCurrentPosition-1]
        // установить отображение кнопок по умолчанию
        defaultOptionsView()
        if(mCurrentPosition == mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        } else {
            btn_submit.text = "SUBMIT"
        }
        // устанавливаем текущую полизицию прогресс-бара
        progressBar.progress = mCurrentPosition
        // устанавилваем значение progress bar текста
        tv_progress.text = "$mCurrentPosition " + "/" + progressBar.max
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

    // деволтный шаблон кнопок
    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3, tv_option_four)
        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            // typeface устанавливает стиль, в котором текст должен отображаться (BOLD, DEFAULT и т.д.)
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
            when(v?.id) {
                R.id.tv_option_one -> {
                    selectedOptionView(tv_option_one, 1)
                }
                R.id.tv_option_two -> {
                    selectedOptionView(tv_option_two, 2)
                }
                R.id.tv_option_three -> {
                    selectedOptionView(tv_option_three, 3)
                }
                R.id.tv_option_four -> {
                    selectedOptionView(tv_option_four, 4)
                }
                R.id.btn_submit -> {
                    if(mSelectedOptionPosition == 0) {
                        // говорит о том, чтоы мы хотим перейти к следующему вопросу
                        mCurrentPosition++
                        when{
                            mCurrentPosition <= mQuestionsList!!.size-> {
                                // перейти к сделующему вопросу
                                setQuestion()
                            } else -> {
                                val intent = Intent(this@QuizQuestionsActivity, ActivityResult::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                                intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                startActivity(intent)
                                finish()
                            }
                        }
                    } else {
                        // получаем обьект, содержащий текущий вопрос
                        val question = mQuestionsList?.get(mCurrentPosition - 1)
                        if(question!!.correctAnswer != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        } else {
                            mCorrectAnswers++
                        }
                            answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                        if(mCurrentPosition == mQuestionsList!!.size) {
                            btn_submit.text = "FINISH"
                        } else {
                            btn_submit.text = "GO TO NEXT QUESTION"
                        }
                        mSelectedOptionPosition = 0
                    }
                }
            }
    }

    private fun answerView(answer:Int, drawableView:Int) {
        when(answer){
            1-> {
                tv_option_one.background = ContextCompat.getDrawable(this, drawableView)
            }
            2-> {
                tv_option_two.background = ContextCompat.getDrawable(this, drawableView)
            }
            3-> {
                tv_option_three.background = ContextCompat.getDrawable(this, drawableView)
            }
            4-> {
                tv_option_four.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum:Int) {
        // cбрасываем отобржаение кнопок на дефолт
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        // typeface устанавливает стиль, в котором текст должен отображаться (BOLD, DEFAULT и т.д.)
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

}
