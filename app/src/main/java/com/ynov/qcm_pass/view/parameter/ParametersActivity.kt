package com.ynov.qcm_pass.view.parameter

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.view.toolBar.ToolbarFragment


class ParametersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameters)

        val toolBar = ToolbarFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, toolBar).commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // ajoute la flèche de retour
    }

    //action flèche de retour
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // gère le clic sur la flèche de retour
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}