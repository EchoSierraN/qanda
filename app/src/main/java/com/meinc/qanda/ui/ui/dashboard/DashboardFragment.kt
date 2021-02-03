package com.meinc.qanda.ui.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.meinc.qanda.R
import com.meinc.qanda.data.TestData
import com.meinc.qanda.databinding.FragmentDashboardBinding
import com.meinc.qanda.models.QAModel
import com.meinc.qanda.models.TestModel
import com.meinc.qanda.utilities.Tags
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import kotlinx.android.synthetic.main.question_layout_4_choice.*
import kotlinx.android.synthetic.main.test_type_card.*


class DashboardFragment : Fragment() {
    private lateinit var dashboardViewModel: DashboardViewModel

    //region VIEW BINDING DECLARATION
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!
    //endregion

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding for fragments
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root

        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val textView: TextView = binding.root.text_fragment
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return view
    }

}
