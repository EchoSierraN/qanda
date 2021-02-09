package com.meinc.qanda.ui.ui.qa

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.meinc.qanda.databinding.ActivityQABinding
import com.meinc.qanda.managers.QAManager
import com.meinc.qanda.ui.ui.dashboard.DashboardViewModel
import kotlinx.android.synthetic.main.activity_q_a.*
import kotlinx.android.synthetic.main.question_layout_4_choice.*

class QAActivity : AppCompatActivity() {

    //region VIEW MODEL DECLARATIONS
    private lateinit var dashboardViewModel: DashboardViewModel
    //endregion

    //region VIEW BINDING DECLARATION
    lateinit var binding: ActivityQABinding
    //endregion

    //region REQUIRED OBJECT DECLARATION

    //endregion

    //region ACTIVITY LAUNCH PARAMS
    private var testId: Int = 0
    //endregion

//    //region QUESTION/ANSWER DECLARATION
//    var timeTotal: Int = 30
//    var timeRemaining: Int = timeTotal
//    var questionIndex: Int =
//        0               //first question, second, and so on. Value 0 means first question
//    var currentTestID: Int = 0
//    var currentTest: TestModel? = null
//    var currentQAData: ArrayList<QAModel>? = null
//    //endregion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //region VIEW BINDING
        binding = ActivityQABinding.inflate(layoutInflater)
        setContentView(binding.root)
        //endregion
        //region PREPARE DATA RECEIVED WITH INTENT
        testId = intent.getIntExtra("TEST_ID", 0)
        QAManager.instance.currentTestID = testId
        //endregion

        //display first question
        QAManager.instance.displayCurrentQuestion(
            tv_question,
            tv_question_number,
            btn_choice1,
            btn_choice2,
            btn_choice3,
            btn_choice4,
            tv_timer
        )

        binding.btnNext.setOnClickListener {

            QAManager.instance.resetHighlight(btn_choice1, btn_choice2, btn_choice3, btn_choice4)

            //Toast.makeText(applicationContext, "Clicked", Toast.LENGTH_SHORT).show()
            QAManager.instance.nextQuestion(
                applicationContext,
                QAManager.instance,
                tv_question,
                tv_question_number,
                btn_choice1,
                btn_choice2,
                btn_choice3,
                btn_choice4,
                tv_timer
            )
        }

    }

    fun startFeedbackDialog(answered: Int, total: Int, context: Context = this.applicationContext){
        val bundle = Bundle()
        bundle.putInt("QUESTION_ANSWERED", answered)
        bundle.putInt("QUESTION_TOTAL", total)
// set Fragmentclass Arguments
// set Fragmentclass Arguments
        val fragmentDialog = FragmentDialog()
        fragmentDialog.arguments= bundle


        FragmentDialog().show(supportFragmentManager, "Result")
    }

}