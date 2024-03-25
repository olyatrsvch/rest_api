package com.example.messagemanager.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.messagemanager.R

const val URL = "https://jsonplaceholder.typicode.com/"


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}