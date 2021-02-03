package com.meinc.qanda.data

import com.meinc.qanda.R
import com.meinc.qanda.data.QAData.qaCpp
import com.meinc.qanda.data.QAData.qaUXUI
import com.meinc.qanda.models.TestModel

object TestData {
    val testData: ArrayList<TestModel> = arrayListOf(
        TestModel(idTest = 1, name = "Python", description = "Take a look", date = "12/12/20", image = R.mipmap.python_5, qaData = QAData.qaCpp),
        TestModel(idTest = 2, name = "UX", description = "Take a look", date = "1/25/21", image = R.mipmap.ux_logo, qaData = qaUXUI),
        TestModel(idTest = 3, name = "C++", description = "Take a look", date = "1/25/21", image = R.mipmap.cpp, qaData = qaCpp),
        TestModel(idTest = 4, name = "JavaScript", description = "Take a look",date = "1/25/21", image = R.mipmap.javascript, qaData = qaCpp),
        TestModel(idTest = 5, name = "HTML5", description = "Take a look", date = "1/25/21", image = R.mipmap.html5, qaData = qaUXUI)
    )
}