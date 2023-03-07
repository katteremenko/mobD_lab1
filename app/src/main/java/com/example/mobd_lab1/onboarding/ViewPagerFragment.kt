package com.example.mobd_lab1.onboarding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.mobd_lab1.R
import com.example.mobd_lab1.onboarding.screens.FirstScreen
import com.example.mobd_lab1.onboarding.screens.SecondScreen
import com.example.mobd_lab1.onboarding.screens.ThirdScreen

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
        //val pag = findViewById<ViewPager>(R.id.viewPager)
        view.findViewById<ViewPager2>(R.id.viewPager).adapter = adapter

        return view
    }

}