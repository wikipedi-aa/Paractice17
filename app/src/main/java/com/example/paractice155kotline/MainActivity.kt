package com.example.paractice155kotline

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import androidx.appcompat.app.AppCompatDelegate
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private var isNightMode = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
title = "Ты клоуна видел??"
        val switch = findViewById<Switch>(R.id.switch1)

        var currentTheme = AppCompatDelegate.getDefaultNightMode()




        isNightMode = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES

        switch.setOnCheckedChangeListener { _, isChecked ->
            setTheme(isChecked)
            Toast.makeText(this,"Молодец, а вот костя не видел!", Toast.LENGTH_LONG).show()
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        updateMenuTheme(menu?.findItem(R.id.theme_menu_item))
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_menu_item -> {
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                return true
            }
            R.id.theme_menu_item -> {
                isNightMode = !isNightMode
                setTheme(isNightMode)
                updateMenuTheme(item)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setTheme(isNightMode: Boolean) {
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun updateMenuTheme(menuItem: MenuItem?) {
        if (isNightMode) {
            menuItem?.title = "Сменить на светлую"
            menuItem?.setIcon(R.drawable.ic_dark_mode)
            Toast.makeText(this,"Так он в приоре не мог его видеть!!!", Toast.LENGTH_LONG).show()
        } else {
            menuItem?.title = "Сменить на тёмную"
            menuItem?.setIcon(R.drawable.ic_light_mode)
            Toast.makeText(this,"Он искал, искал, но клоун очень хорошо спрятался!!", Toast.LENGTH_LONG).show()
        }
    }

    }
