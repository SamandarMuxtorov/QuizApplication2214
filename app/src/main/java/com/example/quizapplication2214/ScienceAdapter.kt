package com.example.quizapplication2214

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapplication2214.databinding.ScienceItemLayoutBinding

interface ScienceAdapterCAllback{
    fun onClick(item: ScienceModel)
}

class ScienceAdapter (val items: List<ScienceModel>, val callback: ScienceAdapterCAllback):RecyclerView.Adapter<ScienceAdapter.ItemHolder>(){
    inner class ItemHolder(val binding: ScienceItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(ScienceItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }
    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = items[position]
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ReportActivity::class.java)
            intent.putExtra("post", item)
            holder.itemView.context.startActivity(intent)
        }
        holder.itemView.setOnClickListener {
            callback.onClick(item)
        }
        holder.binding.tvScience.text = item.title
    }

    override fun getItemCount(): Int {
        return items.count()
    }
}