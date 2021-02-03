package com.meinc.qanda.models

import com.meinc.qanda.R
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

data class TestModel(
    var idTest: Int= 0,
    var name: String = "CourseName",
    var description: String = "Take a look",
    //TODO: see if there are better ways to display date
    var date: String = Date.from(Instant.now()).toString(),
    var image: Int= R.mipmap.ellipse_5,

    //test data here
    var qaData: ArrayList<QAModel>? = null
)