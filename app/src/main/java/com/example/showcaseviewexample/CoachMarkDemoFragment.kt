package com.example.showcaseviewexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class CoachMarkDemoFragment : Fragment() {
    private lateinit var adapter: CoachMarckDemoPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_coachmarck_demo,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CoachMarckDemoPagerAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        //viewPager.adapter = CurrentCoachMarkFragment
    }


}