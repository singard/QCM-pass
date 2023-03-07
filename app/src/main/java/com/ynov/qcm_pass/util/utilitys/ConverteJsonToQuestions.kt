package com.ynov.qcm_pass.util.utilitys

import android.content.Context
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.InputStreamReader
import com.google.gson.Gson
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.model.Category
import com.ynov.qcm_pass.model.Qcm

class ConverteJsonToQuestions {

    companion object {

        private val className = this::class.simpleName

        fun convertJsonToQuestion(context: Context, fileName: String): MutableList<Qcm>? {

            var listQcm = mutableListOf<Qcm>()
            //json
            Log.i(className,"fileName test : ${fileName}")
            val resourceId = context.resources.getIdentifier(
                fileName,
                "raw",
                context.packageName
            )
            if (resourceId != 0) {


                val inputStream = context.resources.openRawResource(resourceId)
                val reader = BufferedReader(InputStreamReader(inputStream))
                val jsonString = reader.use { it.readText() }
                val gson = Gson()


                listQcm = gson.fromJson(jsonString, Array<Qcm>::class.java).asList() as MutableList<Qcm>

                Log.i(className, "" + listQcm.size)
                return listQcm

            } else {
                Log.i(className, "le fichier existe pas")
                return listQcm
            }
        }
    }


}