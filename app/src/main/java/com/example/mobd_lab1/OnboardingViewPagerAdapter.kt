package com.example.mobd_lab1

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnboardingViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val context: Context
):
    FragmentStateAdapter(fragmentActivity) {

    override fun createFragment(position: Int): Fragment{
        return when (position){
            0 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_1),
                context.resources.getString(R.string.description_onboarding_1),
                R.drawable.kids_first_screen
            )

            1 -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_2),
                context.resources.getString(R.string.description_onboarding_1) ,
                R.drawable.kids_second_screen
            )

            else -> OnboardingFragment.newInstance(
                context.resources.getString(R.string.title_onboarding_3),
                context.resources.getString(R.string.description_onboarding_1),
                R.drawable.kids_third_screen
            )
        }
    }
    override fun getItemCount(): Int {
        return 3
    }
}