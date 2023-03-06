package com.ynov.qcm_pass.util.cardViewCategory


import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Category

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewUc: TextView = itemView.findViewById(R.id.textViewUc)
    private val textViewLabel: TextView = itemView.findViewById(R.id.textViewLabel)
    private val cardView: CardView = itemView.findViewById(R.id.cardViewJob) // pour le clic card

    fun bind(category: Category) {
        textViewUc.text = category.uc
        textViewLabel.text = category.label

        //pour le clic sur une card
        cardView.setOnClickListener {

            Toast.makeText(itemView.context, "clic sur : ${category.uc}", Toast.LENGTH_SHORT).show()

            //al intent = Intent(itemView.context, JobDetailActivity::class.java)
            //intent.putExtra("characterClass", characterJob)
            //itemView.context.startActivity(intent)
        }
    }
}