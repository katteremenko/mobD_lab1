package com.example.mobd_lab1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {
    private var email: EditText? = null
    private var password: EditText? = null
    private var isPasswordVisible = false
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)
        var localPassword = password
        localPassword?.setOnTouchListener(OnTouchListener { _, event ->
            val right = 2
            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= localPassword.right - localPassword.compoundDrawables[right].bounds.width() - 50) {
                    val selection = localPassword.selectionEnd
                    if (isPasswordVisible) {
                        localPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_visibility_off,
                            0
                        )
                        localPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                        isPasswordVisible = false
                    } else {
                        localPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(
                            0,
                            0,
                            R.drawable.ic_visibility_on,
                            0
                        )
                        localPassword.inputType = 1
                        isPasswordVisible = true
                    }
                    localPassword.setSelection(selection)
                    this.password = localPassword
                    return@OnTouchListener true
                }
            }
            false
        })
        val btnBack: ImageView = findViewById (R.id.imageView3)
        val btnSignUp: Button = findViewById (R.id.buttonSignUp)
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
        btnBack.setOnClickListener {
            val intent = Intent(this, Onboarding::class.java)
            startActivity(intent)
        }
    }
}