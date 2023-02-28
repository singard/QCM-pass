package com.ynov.qcm_pass.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.ynov.qcm_pass.R
import com.ynov.qcm_pass.onglet.ViewPagerAdapter

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val viewPager = findViewById<ViewPager>(R.id.view_pager_main)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout_main)
        tabLayout.setupWithViewPager(viewPager)
    }
}