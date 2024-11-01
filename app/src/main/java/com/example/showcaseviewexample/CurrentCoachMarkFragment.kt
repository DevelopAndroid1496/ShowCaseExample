package com.example.showcaseviewexample

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class CurrentCoachMarkFragment(private val color: Int): Fragment(){

    private var position = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = View(context)
        view.setBackgroundColor(color)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey("CURRENT_ITEM")}?.apply {
            Log.d("TAG",getInt("CURRENT_ITEM").toString())
            position = getInt("CURRENT_ITEM",-1)
        }

    }


}


