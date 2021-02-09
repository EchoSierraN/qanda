package com.meinc.qanda.ui.ui.qa

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.meinc.qanda.R
import com.meinc.qanda.ui.DashboardActivity
import kotlinx.android.synthetic.main.dialog_qa_result.*


/**
 * was named FragmentDialog because DialogFragment, which would have been proper naming custom,
 * is taken
 */

class FragmentDialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //TODO: set rounded corners for the drawable here :)
        //dialog!!.window?.setBackgroundDrawableResource()

        val answered = requireArguments().getInt("QUESTION_ANSWERED")
        val total = requireArguments().getInt("QUESTION_TOTAL")

        //set values
        tv_result.text= "$answered / $total"

        val builder= AlertDialog.Builder(this.requireContext(), R.style.AppTheme)
        builder.setPositiveButton("btn_close", DialogInterface.OnClickListener { dialogInterface, i ->
            startActivity(Intent(this.context, DashboardActivity::class.java))
        })

        builder.show()

        return inflater.inflate(R.layout.dialog_qa_result, container, false)
    }

    override fun onStart() {
        super.onStart()

    }
}