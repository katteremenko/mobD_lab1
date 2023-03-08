package com.example.mobd_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.mobd_lab1.databinding.ActivityMainBinding
import com.example.mobd_lab1.databinding.ActivityOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class Onboarding : AppCompatActivity() {

    private lateinit var mviewPager: ViewPager2
    private lateinit var textSkip: TextView

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mviewPager = binding.viewPager
        mviewPager.adapter = OnboardingViewPagerAdapter(this, this)
        TabLayoutMediator(binding.pageIndicator, mviewPager) { _, _ ->}.attach()
        textSkip = findViewById(R.id.text_skip)
        textSkip.setOnClickListener {
            finish()
            val intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }

        val btnNextStep: Button = findViewById(R.id.btn_next_step)

        btnNextStep.setOnClickListener {
            if (getItem() > mviewPager.childCount){
                finish()
                val intent = Intent(applicationContext, SignUp::class.java)
                startActivity(intent)
            } else {
                mviewPager.setCurrentItem(getItem() + 1, true)
            }
            }
        }

    private fun getItem(): Int {
        return mviewPager.currentItem
    }

}
