package com.example.kotlinhelloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.TextView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.text_view) as TextView
        val editText = findViewById<EditText>(R.id.edit_text) as EditText
        val button = findViewById<Button>(R.id.button) as Button

        var name: String? = null
        button.setOnClickListener {
            val userName = editText.getText().toString()
            if (!isEmpty(userName.trim())) {
                name = userName
            } else {
                name = WORLD
            }
            textView.setText("Hello $name!")
        }
    }

    companion object {
        const val WORLD: String = "World"
    }
}