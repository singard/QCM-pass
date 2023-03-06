package com.ynov.qcm_pass.view.questionView

import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Answer
import com.ynov.qcm_pass.model.Qcm

class QuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Récupération des éléments graphiques
        val statementTextView = findViewById<TextView>(R.id.question_statement)
        val answerA = findViewById<CheckBox>(R.id.answer_a_checkbox)
        val answerB = findViewById<CheckBox>(R.id.answer_b_checkbox)
        val answerC = findViewById<CheckBox>(R.id.answer_c_checkbox)
        val answerD = findViewById<CheckBox>(R.id.answer_d_checkbox)
        val answerE = findViewById<CheckBox>(R.id.answer_e_checkbox)
        val answerF = findViewById<CheckBox>(R.id.answer_f_checkbox)

        // Récupération de la question et des réponses depuis l'intent
        var listQcm = mutableListOf<Qcm>()

         listQcm = intent.getSerializableExtra("listQcm") as MutableList<Qcm>

        val qcmActual = listQcm.get(0) as Qcm

        // Affichage de la question
        statementTextView.text = qcmActual.statement

        // Affichage des réponses
        answerA.text = qcmActual.answer.get(0).answer_statment
        answerB.text = qcmActual.answer.get(1).answer_statment
        answerC.text = qcmActual.answer.get(2).answer_statment
        answerD.text = qcmActual.answer.get(3).answer_statment
        answerE.text = qcmActual.answer.get(4).answer_statment
        answerF.text = qcmActual.answer.get(5).answer_statment
    }
}