package com.ynov.qcm_pass.card


import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Category

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewName: TextView = itemView.findViewById(R.id.cardName)
    private val cardView: CardView = itemView.findViewById(R.id.cardViewJob) // pour le clic card

    fun bind(category: Category) {
        textViewName.text = category.toString()

        //pour le clic card
        cardView.setOnClickListener {

            Toast.makeText(itemView.context, "clic sur : ${category.toString()}", Toast.LENGTH_SHORT).show()

            //al intent = Intent(itemView.context, JobDetailActivity::class.java)
            //intent.putExtra("characterClass", characterJob)
            //itemView.context.startActivity(intent)
        }
    }
}