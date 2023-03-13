package com.example.mobd_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.mobd_lab1.databinding.ActivityMainBinding
import com.example.mobd_lab1.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class Onboarding : AppCompatActivity() {

    private lateinit var mviewPager: ViewPager2
    private lateinit var btnNextStep: Button
    private lateinit var firstIndicator: ImageView
    private lateinit var secondIndicator: ImageView
    private lateinit var thirdIndicator: ImageView
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mviewPager = binding.viewPager
        mviewPager.adapter = OnboardingViewPagerAdapter(this, this)
        binding.textSkip.setOnClickListener {
            finish()
            val intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }

        btnNextStep = binding.btnNextStep

        btnNextStep.setOnClickListener {
               if (getItem() > mviewPager.childCount){
                finish()
                val intent = Intent(applicationContext, SignUp::class.java)
                startActivity(intent)
            } else {
                mviewPager.setCurrentItem(getItem() + 1, true)
            }
        }
        mviewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                changeIndicator()
                if (position == 0){
                    btnNextStep.text = "Next"
                }
                if (position == 1){
                    btnNextStep.text = "Next"
                }
                if (position == 2){
                    btnNextStep.text = "Let's Start"
                }
                super.onPageSelected(position)
            }
        })

        firstIndicator = binding.firstIndicator
        secondIndicator = binding.secondIndicator
        thirdIndicator = binding.thirdIndicator

        firstIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_active))
        secondIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
        thirdIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
    }

    fun changeIndicator(){
        when(mviewPager.currentItem){
            0 ->
            {
                firstIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_active))
                secondIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
                thirdIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
            }
            1 ->
            {
                firstIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
                secondIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_active))
                thirdIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
            }
            2 ->
            {
                firstIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
                secondIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_grey))
                thirdIndicator.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.onboarding_selector_active))
            }
        }
    }

    private fun getItem(): Int {
        return mviewPager.currentItem
    }

}
