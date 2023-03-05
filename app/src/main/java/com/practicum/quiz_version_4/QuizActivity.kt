package com.practicum.quiz_version_4

import android.content.Intent
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        hideSystemUI()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var i = 1

        val answer1 = findViewById<Button>(R.id.answer_1)
        val answer2 = findViewById<Button>(R.id.answer_2)
        val answer3 = findViewById<Button>(R.id.answer_3)
        val answer4 = findViewById<Button>(R.id.answer_4)

        val images = arrayOf(
            R.drawable.solnechnaya_sistema_1,
            R.drawable.solar_system_2,
            R.drawable.telescope_3,
            R.drawable.pulkovo_observatory_4,
            R.drawable.jules_verne_5,
            R.drawable.tsiolkovsky_6,
            R.drawable.rocket_7,
            R.drawable.lunar_track_8,
            R.drawable.glushko_letter_9,
            R.drawable.cover_10
        )
        val allAnswers = mapOf(
            0 to arrayOf(
                R.string.question_1_answer_1,
                R.string.question_1_answer_2,
                R.string.question_1_answer_3,
                R.string.question_1_answer_4
            ),
            1 to arrayOf(
                R.string.question_2_answer_1,
                R.string.question_2_answer_2,
                R.string.question_2_answer_3,
                R.string.question_2_answer_4
            ),
            2 to arrayOf(
                R.string.question_3_answer_1,
                R.string.question_3_answer_2,
                R.string.question_3_answer_3,
                R.string.question_3_answer_4
            ),
            3 to arrayOf(
                R.string.question_4_answer_1,
                R.string.question_4_answer_2,
                R.string.question_4_answer_3,
                R.string.question_4_answer_4
            ),
            4 to arrayOf(
                R.string.question_5_answer_1,
                R.string.question_5_answer_2,
                R.string.question_5_answer_3,
                R.string.question_5_answer_4
            ),
            5 to arrayOf(
                R.string.question_6_answer_1,
                R.string.question_6_answer_2,
                R.string.question_6_answer_3,
                R.string.question_6_answer_4
            ),
            6 to arrayOf(
                R.string.question_7_answer_1,
                R.string.question_7_answer_2,
                R.string.question_7_answer_3,
                R.string.question_7_answer_4
            ),
            7 to arrayOf(
                R.string.question_8_answer_1,
                R.string.question_8_answer_2,
                R.string.question_8_answer_3,
                R.string.question_8_answer_4
            ),
            8 to arrayOf(
                R.string.question_9_answer_1,
                R.string.question_9_answer_2,
                R.string.question_9_answer_3,
                R.string.question_9_answer_4
            ),
            9 to arrayOf(
                R.string.question_10_answer_1,
                R.string.question_10_answer_2,
                R.string.question_10_answer_3,
                R.string.question_10_answer_4
            )
        )

        val rightAnswers = arrayOf(
            R.string.question_1_answer_3,
            R.string.question_2_answer_2,
            R.string.question_3_answer_1,
            R.string.question_4_answer_2,
            R.string.question_5_answer_4,
            R.string.question_6_answer_4,
            R.string.question_7_answer_1,
            R.string.question_8_answer_4,
            R.string.question_9_answer_2,
            R.string.question_10_answer_2
        )
        val questions = arrayOf(
            R.string.question_1,
            R.string.question_2,
            R.string.question_3,
            R.string.question_4,
            R.string.question_5,
            R.string.question_6,
            R.string.question_7,
            R.string.question_8,
            R.string.question_9,
            R.string.question_10
        )

        for (q in questions) {

            answer1.setOnClickListener {
                if (getText(rightAnswers[i - 1]) == answer1.text) {
                    answer1.background =
                        ContextCompat.getDrawable(this, R.drawable.transition_drawable_correct)
                    startCorrectColorAnimation(answer1)
                    Handler(Looper.getMainLooper()).postDelayed({
                        showNextScreen(i++, images, allAnswers, questions)
                    }, 600)

                } else
                    showIncorrectAnswer(answer1)
            }

            answer2.setOnClickListener {
                if (getText(rightAnswers[i - 1]) == answer2.text) {
                    answer2.background =
                        ContextCompat.getDrawable(this, R.drawable.transition_drawable_correct)
                    startCorrectColorAnimation(answer2)
                    Handler(Looper.getMainLooper()).postDelayed({
                        showNextScreen(i++, images, allAnswers, questions)
                    }, 600)
                } else
                    showIncorrectAnswer(answer2)
            }

            answer3.setOnClickListener {
                if (getText(rightAnswers[i - 1]) == answer3.text) {
                    answer3.background =
                        ContextCompat.getDrawable(this, R.drawable.transition_drawable_correct)
                    startCorrectColorAnimation(answer3)
                    Handler(Looper.getMainLooper()).postDelayed({
                        showNextScreen(i++, images, allAnswers, questions)
                    }, 600)
                } else
                    showIncorrectAnswer(answer3)
            }

            answer4.setOnClickListener {
                if (getText(rightAnswers[i - 1]) == answer4.text) {
                    answer4.background =
                        ContextCompat.getDrawable(this, R.drawable.transition_drawable_correct)
                    startCorrectColorAnimation(answer4)
                    Handler(Looper.getMainLooper()).postDelayed({
                        showNextScreen(i++, images, allAnswers, questions)
                    }, 600)
                } else
                    showIncorrectAnswer(answer4)
            }
        }
    }

    private fun showNextQuestion(
        i: Int,
        images: Array<Int>,
        allAnswers: Map<Int, Array<Int>>,
        questions: Array<Int>
    ) {
        val image = findViewById<ImageView>(R.id.image)
        val question = findViewById<TextView>(R.id.question)
        val answer1 = findViewById<Button>(R.id.answer_1)
        val answer2 = findViewById<Button>(R.id.answer_2)
        val answer3 = findViewById<Button>(R.id.answer_3)
        val answer4 = findViewById<Button>(R.id.answer_4)

        val answers = allAnswers[i]!!

        image.setImageResource(images[i])
        question.setText(questions[i])

        answer1.setText(answers[0])
        answer2.setText(answers[1])
        answer3.setText(answers[2])
        answer4.setText(answers[3])

    }

    private fun showNextScreen(
        i: Int,
        images: Array<Int>,
        allAnswers: Map<Int, Array<Int>>,
        questions: Array<Int>
    ) {
        try {

            showNextQuestion(i, images, allAnswers, questions)
        } catch (e: java.lang.Exception) {
            startActivity(Intent(this@QuizActivity, FinalActivity::class.java))
        }

    }

    private fun showIncorrectAnswer(b: Button) {
        b.background = ContextCompat.getDrawable(this, R.drawable.transition_drawable_incorrect)
        startIncorrectColorAnimation(b)


    }

    private fun startIncorrectColorAnimation(b: Button) {

        val drawable: Drawable = b.background
        if (drawable is TransitionDrawable) {
            drawable.startTransition(200)
            Handler(Looper.getMainLooper()).postDelayed({
                drawable.reverseTransition(200)
            }, 200)
            Handler(Looper.getMainLooper()).postDelayed({
                drawable.startTransition(200)
            }, 400)
            Handler(Looper.getMainLooper()).postDelayed({
                drawable.reverseTransition(200)
            }, 900)
        }
    }

    private fun startCorrectColorAnimation(b: Button) {

        val drawable: Drawable = b.background
        if (drawable is TransitionDrawable) {
            drawable.startTransition(200)
            Handler(Looper.getMainLooper()).postDelayed({
                drawable.reverseTransition(200)
            }, 400)
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


