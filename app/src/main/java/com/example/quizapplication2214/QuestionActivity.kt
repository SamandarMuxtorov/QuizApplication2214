package com.example.quizapplication2214

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication2214.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {
    lateinit var binding: ActivityQuestionBinding

    lateinit var science: ScienceModel
    var index = 0
    var correctCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        science = intent.getSerializableExtra("extra") as ScienceModel
        binding.imgBack.setOnClickListener {
            finish()
        }

        binding.btnA.setOnClickListener {
            if (index <= science.quizList.size - 1) {
                science.quizList[index].answer = "A"
                if (science.quizList[index].correctAnswer == "A") {
                    correctCount++
                }
            }
            index++
            setQuiz()
        }

        binding.btnB.setOnClickListener {
            if (index <= science.quizList.size - 1) {
                science.quizList[index].answer = "B"
                if (science.quizList[index].correctAnswer == "B") {
                    correctCount++
                }
            }
            index++
            setQuiz()
        }

        binding.btnC.setOnClickListener {
            if (index <= science.quizList.size - 1) {
                science.quizList[index].answer = "C"
                if (science.quizList[index].correctAnswer == "C") {
                    correctCount++
                }
            }
            index++
            setQuiz()
        }

        binding.btnD.setOnClickListener {
            if (index <= science.quizList.size - 1) {
                science.quizList[index].answer = "D"
                if (science.quizList[index].correctAnswer == "D") {
                    correctCount++
                }
            }
            index++
            setQuiz()
        }
        setQuiz()

    }

    fun setQuiz() {
        if (index < science.quizList.count()) {
            val quiz = science.quizList[index]
            binding.tvQuiz.text = quiz.title

            if (quiz.image != null) {
                binding.imgQuiz.visibility = View.VISIBLE
                binding.imgQuiz.setImageResource(quiz.image)
            } else {
                binding.imgQuiz.visibility = View.GONE
            }
            binding.btnA.text = quiz.answerA
            binding.btnB.text = quiz.answerB
            binding.btnC.text = quiz.answerC
            binding.btnD.text = quiz.answerD
        } else {
            Toast.makeText(
                this,
                "Siz ${science.quizList.count()} ta savoldan ${correctCount} ta savolga to'g'ri javob berdingiz",
                Toast.LENGTH_LONG
            ).show()

            val intent = Intent(this, ReportActivity::class.java)
            intent.putExtra("extra_data", science)
            startActivity(intent)
        }
    }
}