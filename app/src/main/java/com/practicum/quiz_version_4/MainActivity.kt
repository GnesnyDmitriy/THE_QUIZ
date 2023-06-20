package com.practicum.quiz_version_4

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        hideSystemUI()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainButton = findViewById<ImageView>(R.id.main_button)




        mainButton.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }

        val rightAnswers = arrayOf(
            getString(R.string.question_1_answer_3),
            getString(R.string.question_2_answer_2),
            getString(R.string.question_3_answer_1),
            getString(R.string.question_4_answer_2),
            getString(R.string.question_5_answer_4),
            getString(R.string.question_6_answer_4),
            getString(R.string.question_7_answer_1),
            getString(R.string.question_8_answer_4),
            getString(R.string.question_9_answer_2),
            getString(R.string.question_10_answer_2)
        )
        val questions = arrayOf(
            getString(R.string.question_1),
            getString(R.string.question_2),
            getString(R.string.question_3),
            getString(R.string.question_4),
            getString(R.string.question_5),
            getString(R.string.question_6),
            getString(R.string.question_7),
            getString(R.string.question_8),
            getString(R.string.question_9),
            getString(R.string.question_10)
        )

        val executor = Executors.newCachedThreadPool()
        val dataBase = DataBase(this)

        executor.execute {
            dataBase.writeData("questions_key", questions)
            dataBase.writeData("rightAnswers_key", rightAnswers)
        }



    }

    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val insetsController = WindowCompat.getInsetsController(window, window.decorView)
        insetsController.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        insetsController.hide((WindowInsetsCompat.Type.systemBars()))
    }
}