package com.meinc.qanda.managers

import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.meinc.qanda.data.TestData
import com.meinc.qanda.models.QAModel
import com.meinc.qanda.models.TestModel
import com.meinc.qanda.utilities.Tags

/**
 * Manages what questions are to be passed to an activity
 */
class QAManager(
    //region QUESTION/ANSWER DECLARATION
    var timeTotal: Int = 30,
    var timeRemaining: Int = timeTotal,
    //first question, second, and so on. Value 0 means first question
    var questionIndex: Int = 0,
    var currentTestID: Int = 1,
    var currentTest: TestModel? = null,
    var currentQAData: ArrayList<QAModel>? = null
    //endregion
) {

    fun displayCurrentQuestion(
        //currentQuestionIndex: Int = questionIndex,
        question: TextView,
        whathQuestion: TextView,
        choice1: Button,
        choice2: Button,
        choice3: Button,
        choice4: Button,
        timeRemaining: TextView
    ) {
        getCurrentQA()
        //checks
        nullCheck()
        //set the time remaining
        timeRemaining.text = currentQAData?.get(questionIndex)?.time.toString()
        //set whath question this is
        whathQuestion.text = "${questionIndex + 1} of ${currentQAData!!.size + 1}"
        //set question and choices
        question.text = currentQAData?.get(questionIndex)?.question
        choice1.text = currentQAData?.get(questionIndex)?.choice1
        choice2.text = currentQAData?.get(questionIndex)?.choice2
        choice3.text = currentQAData?.get(questionIndex)?.choice3
        choice4.text = currentQAData?.get(questionIndex)?.choice4

    }

    private fun nullCheck() {
        if (currentTest!!.qaData == null) {
            Log.d(Tags.tag_Dashboard, "currentTestData is NULL.")
            return
        } else if (timeTotal == 0) {
            Log.d(Tags.tag_Dashboard, "currentTestData is NULL.")
            return
        }

    }

    private fun getCurrentQA(){
        //get the relevant test and test data from database
        TestData.testData.let {
            for (i in 0..it.size) {
                if (currentTestID == it[i].idTest) {
                    currentQAData = it[i].qaData
                    break
                }
            }

            if (currentQAData == null) {
                Log.d(Tags.tag_Dashboard, "currentQAData is NULL.")
                return
            }

            Log.d(Tags.tag_Dashboard, "PASSED ALL NULL CHECKS.")
        }
    }

    private fun nextQuestion() {

    }
}