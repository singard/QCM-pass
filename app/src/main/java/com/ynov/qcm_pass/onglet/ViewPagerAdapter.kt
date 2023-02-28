package com.ynov.qcm_pass.onglet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ynov.qcm_pass.view.CategorieFragment
import com.ynov.qcm_pass.view.StatFragment

class ViewPagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CategorieFragment()
            1 -> StatFragment()
            else -> CategorieFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "catégorie"
            1 -> "statistique"
            else -> null
        }
    }
}
