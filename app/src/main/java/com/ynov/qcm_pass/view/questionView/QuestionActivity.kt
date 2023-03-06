package com.ynov.qcm_pass.view.questionView

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Qcm

class QuestionActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Restaure la valeur de currentQuestionIndex à partir du Bundle s'il existe
        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex")
        }

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

        val qcmActual = listQcm.get(currentQuestionIndex) as Qcm

        // Affichage de la question
        statementTextView.text = qcmActual.statement

        // Affichage des réponses
        answerA.text = qcmActual.answer.get(0).answer_statment
        answerB.text = qcmActual.answer.get(1).answer_statment
        answerC.text = qcmActual.answer.get(2).answer_statment
        answerD.text = qcmActual.answer.get(3).answer_statment
        answerE.text = qcmActual.answer.get(4).answer_statment
        answerF.text = qcmActual.answer.get(5).answer_statment

        val button = findViewById<Button>(R.id.validate_button)

        button.setOnClickListener {

            val selectedAnswers = mutableListOf<String>()

            if (answerA.isChecked) selectedAnswers.add("a")
            if (answerB.isChecked) selectedAnswers.add("b")
            if (answerC.isChecked) selectedAnswers.add("c")
            if (answerD.isChecked) selectedAnswers.add("d")
            if (answerE.isChecked) selectedAnswers.add("e")
            if (answerF.isChecked) selectedAnswers.add("f")

            val isAnswerCorrect = verifyAnswer(selectedAnswers,
                qcmActual.correct_answers as MutableList<String>
            )

            if (isAnswerCorrect) {
                // Réponse correcte
            } else {
                // Réponse incorrecte
            }

            currentQuestionIndex++

            if (currentQuestionIndex < listQcm.size) {
                Toast.makeText(this, "${currentQuestionIndex}", Toast.LENGTH_SHORT).show()

                recreate()
            } else {
                // Afficher le résultat
                Toast.makeText(this, "fini", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun verifyAnswer(selectedAnswers: MutableList<String>, correctAnswers: MutableList<String>): Boolean {

        if (selectedAnswers.size != correctAnswers.size) {
            return false
        }

        val set1 = HashSet(selectedAnswers)
        val set2 = HashSet(correctAnswers)

        return set1.size == set2.size && set1.containsAll(set2)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentQuestionIndex", currentQuestionIndex)
    }

}