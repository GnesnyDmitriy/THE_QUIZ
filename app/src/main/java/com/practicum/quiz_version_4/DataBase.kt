package com.practicum.quiz_version_4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write

const val APP_PREF_KEY = "key"

class DataBase(
    context: Context,
) {

    private val preferences =
        context.getSharedPreferences(APP_PREF_KEY, AppCompatActivity.MODE_PRIVATE)
    private val gson = Gson()


    private val lock = ReentrantReadWriteLock()
    fun <T> writeData(key: String, data: T) {
        lock.write {
            when (data) {
                is Boolean -> preferences.edit().putBoolean(key, data).apply()
                is Int -> preferences.edit().putInt(key, data).apply()
                is String -> preferences.edit().putString(key, data).apply()
                else -> preferences.edit().putString(key, gson.toJson(data)).apply()
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> readData(key: String, defaultValue: T): T {
        lock.read {
            return when (defaultValue) {
                is Boolean -> preferences.getBoolean(key, defaultValue as Boolean) as T
                is Int -> preferences.getInt(key, defaultValue as Int) as T
                is String -> preferences.getString(key, defaultValue) as T
                else -> preferences.getObject(key, defaultValue)
            }
        }
    }

    private fun <T> SharedPreferences.getObject(key: String, defaultValue: T): T {
        val json = this.getString(key, null)
        return if (json == null || json == "null")
            defaultValue
        else
            gson.fromJson(json, defaultValue!!::class.java)
    }
}