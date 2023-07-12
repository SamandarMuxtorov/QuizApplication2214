package com.example.quizapplication2214

import java.io.Serializable

data class ScienceModel(
    val title: String,
    val quizList: List<QuizModel>
) : Serializable

data class QuizModel(
    val title: String,
    val image: Int?,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    var correctAnswer: String,
    var answer: String = " "
) : Serializable