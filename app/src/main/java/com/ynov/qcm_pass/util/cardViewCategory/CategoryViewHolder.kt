package com.ynov.qcm_pass.util.cardViewCategory


import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Category
import com.ynov.qcm_pass.model.Qcm
import com.ynov.qcm_pass.util.utilitys.ConverteJsonToQuestions
import com.ynov.qcm_pass.view.questionView.QuestionActivity

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textViewUc: TextView = itemView.findViewById(R.id.textViewUc)
    private val textViewLabel: TextView = itemView.findViewById(R.id.textViewLabel)
    private val cardView: CardView = itemView.findViewById(R.id.cardViewJob) // pour le clic card

    private val className = this::class.simpleName

    fun bind(category: Category) {
        textViewUc.text = category.ue
        textViewLabel.text = category.label

        //pour le clic sur une card
        cardView.setOnClickListener {

            Toast.makeText(itemView.context, "clic sur : ${category.ue}", Toast.LENGTH_SHORT).show()

            //var listQcm = mutableListOf<Qcm>()?()
            var listQcm=ConverteJsonToQuestions.convertJsonToQuestion(itemView.context,category.ue+"_qcm")

            Log.i(className,"${listQcm}")


            val intent = Intent(itemView.context, QuestionActivity::class.java)
            intent.putExtra("listQcm", ArrayList(listQcm))
            itemView.context.startActivity(intent)
        }
    }
}