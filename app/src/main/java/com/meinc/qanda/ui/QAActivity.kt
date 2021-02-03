package com.meinc.qanda.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.meinc.qanda.R
import com.meinc.qanda.data.TestData
import com.meinc.qanda.databinding.ActivityQABinding
import com.meinc.qanda.databinding.FragmentDashboardBinding
import com.meinc.qanda.managers.QAManager
import com.meinc.qanda.models.QAModel
import com.meinc.qanda.models.TestModel
import com.meinc.qanda.ui.ui.dashboard.DashboardFragment
import com.meinc.qanda.ui.ui.dashboard.DashboardViewModel
import com.meinc.qanda.utilities.Tags
import kotlinx.android.synthetic.main.activity_q_a.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.question_layout_4_choice.*

class QAActivity : AppCompatActivity() {

    //region VIEW MODEL DECLARATIONS
    private lateinit var dashboardViewModel: DashboardViewModel
    //endregion

    //region VIEW BINDING DECLARATION
    private lateinit var binding: ActivityQABinding
    //endregion

    //region REQUIRED OBJECT DECLARATION
    private var qaManager = QAManager()

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
        testId= intent.getIntExtra("TEST_ID", 0)
        qaManager.currentTestID= testId
        //endregion
        //display first question
        qaManager.
                displayCurrentQuestion(
            tv_question,
            tv_question_number,
            btn_choice1,
            btn_choice2,
            btn_choice3,
            btn_choice4,
            tv_timer
        )


        //nullCheck()
//        displayCurrentQuestion(
//            questionIndex,
//            tv_question,
//            tv_question_number,
//            btn_choice1,
//            btn_choice2,
//            btn_choice3,
//            btn_choice4,
//            tv_timer
//        )

//        binding.btnNext.setOnClickListener {
//            nextQuestion()
//        }
    }

}