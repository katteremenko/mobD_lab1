package com.example.mobd_lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val btnSignUp: Button = findViewById (R.id.buttonSignUp)
        val btnBack: ImageView = findViewById (R.id.imageView3)
        val etEmail: EditText = findViewById (R.id.editTextTextEmailAddress)
        val etPswd: EditText = findViewById (R.id.editTextTextPassword)
        btnSignUp.setOnClickListener{
            if(etEmail.text.toString().isEmpty()) {
                etEmail.hint = "Enter your e-mail"
            } else if(etPswd.text.toString().isEmpty()) {
                etPswd.hint = "Enter your password"

            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        btnBack.setOnClickListener{
            val intent = Intent(this, Onboarding::class.java)
            startActivity(intent)
            }
    }


}

