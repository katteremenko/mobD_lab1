package com.example.mobd_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mobd_lab1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Dictionary())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.dictionary -> replaceFragment(Dictionary())
                R.id.training -> replaceFragment(Training())
                R.id.video -> replaceFragment(Video())

                else ->{

                }
            }
            true
        }

   }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}