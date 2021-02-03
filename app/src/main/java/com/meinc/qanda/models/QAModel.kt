package com.meinc.qanda.models

data class QAModel(
    var question: String,
    var choice1: String,
    var choice2: String,
    var choice3: String,
    var choice4: String,
    var time: Int = 30,
    var answer: Int,
    var userAnswer: Int? = null
)
