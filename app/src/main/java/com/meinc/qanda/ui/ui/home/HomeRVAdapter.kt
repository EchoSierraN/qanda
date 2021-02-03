package com.meinc.qanda.ui.ui.home

import android.app.Application
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.meinc.qanda.R
import com.meinc.qanda.models.TestModel
import com.meinc.qanda.ui.QAActivity
import kotlinx.android.synthetic.main.test_type_card.view.*

class HomeRVAdapter(private var arrayList: ArrayList<TestModel>, val context: Context) :
    RecyclerView.Adapter<HomeRVAdapter.ViewHolder>() {

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {

        fun bindItems(model: TestModel) {
            itemView.tv_date.text = model.date
            itemView.tv_name.text = model.name
            itemView.tv_description.text = model.description
            itemView.iv_test.setImageResource(model.image)

            itemView.setOnClickListener {
                //Toast.makeText(context, "$model.date Clicked!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context)
            .inflate(R.layout.test_type_card, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener {
            //Toast.makeText(context, "${arrayList[position]} clicked!", Toast.LENGTH_SHORT).show()
            //create an intent passing in a bundle
            val intent= Intent(this.context, QAActivity::class.java)
            intent.putExtra("TEST_ID", arrayList[position].idTest)
            //start QAActivity with that intent
            context.startActivity(intent)
        }
    }
}