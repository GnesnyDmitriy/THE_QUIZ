package com.practicum.quiz_version_4

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        hideSystemUI()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)


        val finalButton = findViewById<ImageView>(R.id.final_button)

        finalButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        insetsController.hide((WindowInsetsCompat.Type.systemBars()))
    }
}