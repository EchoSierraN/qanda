package com.meinc.qanda.managers

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.meinc.qanda.R
import com.meinc.qanda.data.TestData
import com.meinc.qanda.models.QAModel
import com.meinc.qanda.models.TestModel
import com.meinc.qanda.ui.ui.qa.FragmentDialog
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
    var currentQAData: ArrayList<QAModel>? = null,
    //endregion
    //region OTHER DECLARATIONS
    //endregion
    var qTimer: QuestionTimer = QuestionTimer()
) {

    var currentQuestion: QAModel? = null
    var buttonList: MutableList<Button> = mutableListOf()

    companion object {
        val instance: QAManager = QAManager()
    }


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
        //set the time remaining
        qTimer.textViewTimer = timeRemaining
        startTimer(timeRemaining)
        //set whath question this is
        whathQuestion.text = "${questionIndex + 1} of ${currentQAData!!.size}"
        //set question and choices
        question.text = currentQAData?.get(questionIndex)?.question
        choice1.text = currentQAData?.get(questionIndex)?.choice1
        choice2.text = currentQAData?.get(questionIndex)?.choice2
        choice3.text = currentQAData?.get(questionIndex)?.choice3
        choice4.text = currentQAData?.get(questionIndex)?.choice4
        //prepare buttons for answer
        prepareCheckAnswer(
            choice1,
            choice2,
            choice3,
            choice4,
            currentQAData!![questionIndex].answer
        )
    }

    private fun startTimer(timeRemaining: TextView) {
        var time: Int = currentQAData?.get(questionIndex)!!.time
        timeRemaining.text = time.toString()

        qTimer.start()
    }

    private fun stopTimer() {
        qTimer.cancel()
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

    private fun getCurrentQA() {
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

    public fun nextQuestion(
        context: Context,
        qaManager: QAManager,
        question: TextView,
        whathQuestion: TextView,
        choice1: Button,
        choice2: Button,
        choice3: Button,
        choice4: Button,
        timeRemaining: TextView
    ) {
        qTimer.cancel()
        if (qaManager.questionIndex < (qaManager.currentQAData!!.size-1)) {
            qaManager.questionIndex++
            currentQuestion = qaManager.currentQAData!![questionIndex]
            qaManager.displayCurrentQuestion(
                question,
                whathQuestion,
                choice1,
                choice2,
                choice3,
                choice4,
                timeRemaining
            )
        } else {
            displayFeedback(instance, context)
        }
    }

    private fun displayFeedback(qaManager: QAManager, context: Context) {
        Toast.makeText(context, "End of Exam", Toast.LENGTH_SHORT).show()
    }


    private fun prepareCheckAnswer(
        button1: Button,
        button2: Button,
        button3: Button,
        button4: Button,
        answer: Int
    ) {
        buttonList.add(button1)
        buttonList.add(button2)
        buttonList.add(button3)
        buttonList.add(button4)

        //highlight the right answer
        buttonList.forEachIndexed { index, button ->
            setUserAnswer(index)
            if (index == answer) {
                button.setOnClickListener {
                    stopTimer()
                    highlightRight(button)
                }
            } else {
                button.setOnClickListener {
                    stopTimer()
                    highlightWrong(button)
                    highlightRight(buttonList[answer])
                }
            }
        }
    }

    private fun setUserAnswer(index: Int) {
        instance.currentQAData!![questionIndex].userAnswer = index
    }

    fun highlightRight(button: Button) {
        button.setBackgroundResource(R.color.green)
    }

    fun highlightWrong(button: Button) {
        button.setBackgroundResource(R.color.red)
    }

    fun resetHighlight(vararg button: Button) {
        for (b in button) {
            b.setBackgroundResource(R.color.white)
        }
    }

    fun resultCount(): Int{
        var result: Int= 0
        for(i in 0..instance.currentQAData!!.size){
            if(currentQAData!![i].answer == currentQAData!![i].userAnswer){
                result++
            }
        }

        return result
    }

}

//region INNER CLASS COUNTDOWN TIMER
class QuestionTimer(var questionTime: Long = 30000) : CountDownTimer(questionTime, 1000) {
    lateinit var textViewTimer: TextView

    override fun onTick(p0: Long) {
        textViewTimer.text = (p0 / 1000).toString()
    }

    override fun onFinish() {
        val manager = QAManager.instance
        val buttonIndex = manager.currentQAData!![manager.questionIndex].answer
        //highlight the right answer
        manager.highlightRight(manager.buttonList[buttonIndex])
        this.cancel()
    }
}
