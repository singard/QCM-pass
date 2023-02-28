package com.ynov.qcm_pass.card

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ynov.qcm_pass.R

class CategoryAdapter(private val categorys: List<com.ynov.qcm_pass.model.Category>) : RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categorys.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categorys[position]
        holder.bind(category)
    }
}