package com.example.showcaseviewexample

import android.graphics.Color
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CoachMarckDemoPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    private val colors = listOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE
    )
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment = CurrentCoachMarkFragment(colors[position])


}