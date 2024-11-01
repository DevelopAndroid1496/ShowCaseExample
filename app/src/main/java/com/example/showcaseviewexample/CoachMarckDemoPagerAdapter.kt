package com.example.showcaseviewexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class CoachMarckDemoPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        val currentCoachMark = CurrentCoachMarkFragment()
        currentCoachMark.arguments = Bundle().apply {
            putInt("CURRENT_ITEM",position + 1)
        }
        return currentCoachMark
    }


}