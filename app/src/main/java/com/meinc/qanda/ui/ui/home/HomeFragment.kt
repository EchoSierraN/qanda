package com.meinc.qanda.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.meinc.qanda.R
import com.meinc.qanda.data.TestData
import com.meinc.qanda.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.question_layout_4_choice.*

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding= FragmentHomeBinding.bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //view binding for fragments
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val textView: TextView = binding.root.text_home

        //region Populate recyclerview
        val homeRVAdapter= HomeRVAdapter(TestData.testData, requireContext())
        binding.rvTestTypeList.layoutManager= LinearLayoutManager(this.context)
        binding.rvTestTypeList.adapter= homeRVAdapter

        //endregion

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        //region SET CLICK LISTENERS FOR BUTTONS

        //endregion

        //return root
        return view
    }
}