package com.example.kotlinhelloworld.kind02

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import com.example.kotlinhelloworld.R

class MainActivity : AppCompatActivity() {
    val ERROR_MESSAGES = mapOf(
        "ERROR_TITLE" to "ERROR!",
        "EMPTY_VALUE" to "名前を入力して下さい。",
        "TOO_LONG_NAME" to "10文字以内で入力して下さい。"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text_view) as TextView
        val editText = findViewById<EditText>(R.id.edit_text) as EditText
        val button = findViewById<Button>(R.id.button) as Button

        button.setOnClickListener {
            val name = editText.getText().toString()
            if (validate(name)) textView.setText("Hello $name!")
        }
    }

    private fun validate(name : String) :Boolean {
        if (isEmpty(name.trim())) {
            AlertDialog.Builder(this)
                .setTitle(ERROR_MESSAGES["ERROR_TITLE"])
                .setMessage(ERROR_MESSAGES["EMPTY_VALUE"])
                .setPositiveButton("OK"){ _, _ -> }
                .show()
            return false
        }
        if (name.length > 10) {
            AlertDialog.Builder(this)
                .setTitle(ERROR_MESSAGES["ERROR_TITLE"])
                .setMessage(ERROR_MESSAGES["TOO_LONG_NAME"])
                .setPositiveButton("OK"){ _, _ -> }
                .show()
            return false
        }
        return true
    }
}