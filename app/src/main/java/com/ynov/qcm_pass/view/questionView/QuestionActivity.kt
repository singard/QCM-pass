package com.ynov.qcm_pass.view.questionView

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.database.DatabaseHandler
import com.ynov.qcm_pass.model.Qcm
import com.ynov.qcm_pass.model.Stat
import com.ynov.qcm_pass.view.home.HomeActivity
import java.text.SimpleDateFormat
import java.util.*

class QuestionActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var goodAnswer = 0

    private val className = this::class.simpleName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Restaure la valeur de currentQuestionIndex à partir du Bundle s'il existe
        if (savedInstanceState != null) {
            currentQuestionIndex = savedInstanceState.getInt("currentQuestionIndex")
            goodAnswer = savedInstanceState.getInt("goodAnswer")
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
        answerA.text = "a) "+qcmActual.answers.get(0).answer_statement
        answerB.text = "b) "+qcmActual.answers.get(1).answer_statement
        answerC.text = "c) "+qcmActual.answers.get(2).answer_statement
        answerD.text = "d) "+qcmActual.answers.get(3).answer_statement
        answerE.text = "e) "+qcmActual.answers.get(4).answer_statement
        answerF.text = "f) "+qcmActual.answers.get(5).answer_statement

        val button = findViewById<Button>(R.id.validate_button)

        button.setOnClickListener {

            val selectedAnswers = mutableListOf<String>()

            if (answerA.isChecked) selectedAnswers.add("A")
            if (answerB.isChecked) selectedAnswers.add("B")
            if (answerC.isChecked) selectedAnswers.add("C")
            if (answerD.isChecked) selectedAnswers.add("D")
            if (answerE.isChecked) selectedAnswers.add("E")
            if (answerF.isChecked) selectedAnswers.add("F")

            val isAnswerCorrect = verifyAnswer(selectedAnswers,
                qcmActual.correct_answers as MutableList<String>
            )

            if (isAnswerCorrect) {
                goodAnswer++
            } else {
                // Réponse incorrecte
            }

            currentQuestionIndex++

            if (currentQuestionIndex < listQcm.size) {
                recreate()
            } else {

                Log.i(className,"total questions ${currentQuestionIndex+1}")
                Log.i(className,"good answer ${goodAnswer}")
                //TODO envoyer les données au stats

                val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = Date()

                val context = this
                var stat = Stat(dateFormat.format(date), ((100*goodAnswer)/currentQuestionIndex).toFloat())
                var db = DatabaseHandler(context)
                db.insertData(stat)

                goodAnswer=0
                currentQuestionIndex=0
                //renvoie sur la page principale
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)

            }
        }
    }

    private fun verifyAnswer(selectedAnswers: MutableList<String>, correctAnswers: MutableList<String>): Boolean {
        Log.i("sdr","selectedAnswers ${selectedAnswers.size}")
        Log.i("sdr","correctAnswers ${correctAnswers.size}")
        if (selectedAnswers.size != correctAnswers.size) {
            return false
        }

        val set1 = HashSet(selectedAnswers)
        val set2 = HashSet(correctAnswers)
Log.i("sdr","selectedAnswers ${selectedAnswers}")
        Log.i("sdr","correctAnswers ${correctAnswers}")

        Log.i("sdr","set1.size == set2.size && set1.containsAll(set2) : ${set1.size == set2.size && set1.containsAll(set2)}")
        return set1.size == set2.size && set1.containsAll(set2)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("currentQuestionIndex", currentQuestionIndex)
        outState.putInt("goodAnswer", goodAnswer)
    }

}