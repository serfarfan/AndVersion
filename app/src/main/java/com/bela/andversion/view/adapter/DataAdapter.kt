package com.bela.andversion.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bela.andversion.R
import com.bela.andversion.model.data.Android
import kotlinx.android.synthetic.main.recycler_view_row.view.*

class DataAdapter(
    private val dataList: ArrayList<Android>
) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    fun updateAndroidList(newAndroidList: List<Android>) {
        dataList.clear()
        dataList.addAll(newAndroidList)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.tv_name.text = dataList[position].name
        holder.view.tv_version.text = dataList[position].version
        holder.view.tv_api_level.text = dataList[position].apiLevel
    }

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view)

}