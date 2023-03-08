package com.ynov.qcm_pass.view.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.database.DatabaseHandler
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class StatFragment: Fragment() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setHasOptionsMenu(true)
        }
        @RequiresApi(Build.VERSION_CODES.O)
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
        ): View? {
            val context = context
            var db = context?.let { DatabaseHandler(it) }
            var data = db?.readData()

            val view = inflater.inflate(R.layout.fragment_stat, container, false)

            val tvStat = view.findViewById<TextView>(R.id.tvStat)
            tvStat.text = ""
            if (data != null) {
                for (i in 0 until data.size) {
                    tvStat.append(data[i].date + ": " + data[i].goodAnswerPercentage + " % de bonnes réponses \n")
                }
            }

            return view
        }
    }