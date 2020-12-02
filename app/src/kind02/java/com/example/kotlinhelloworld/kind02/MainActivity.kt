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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.text_view) as TextView
        val editText = findViewById<EditText>(R.id.edit_text) as EditText
        val button = findViewById<Button>(R.id.button) as Button

        button.setOnClickListener {
            var name = WORLD
            val userName = editText.getText().toString()
            if (!isEmpty(userName.trim())) {
                if (validate(userName)) {
                    name = userName
                }
            }
            textView.setText("Hello $name!")
        }
    }

    companion object {
        const val WORLD: String = "World"
        val ERROR_MESSAGES = mapOf("ERROR_TITLE" to "ERROR!", "TOO_LONG_NAME" to "10文字以内で入力して下さい。")
    }

    private fun validate(userName : String) : Boolean{
        if(userName.length > 10){
            AlertDialog.Builder(this)
                .setTitle(ERROR_MESSAGES["ERROR_TITLE"])
                .setMessage(ERROR_MESSAGES["TOO_LONG_NAME"])
                .setPositiveButton("OK"){ dialog, which -> }
                .show()
            return false
        }
        return true
    }
}