package ru.gb.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import ru.gb.kotlin_lesson1.R

class MainActivity : AppCompatActivity() {

    private lateinit var titleTextView : TextView
    private lateinit var setWordTextView : TextView
    private lateinit var keyTextView : TextView
    private lateinit var secretTextView : TextView
    private lateinit var showSecretWordCheckBox : CheckBox
    private lateinit var inputWordEditTextView : EditText
    private lateinit var actionButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        titleTextView = findViewById<TextView>(R.id.title_text_view)
        setWordTextView = findViewById<TextView>(R.id.set_of_words_text_view)
        keyTextView = findViewById<TextView>(R.id.key_word_text_view)
        secretTextView = findViewById<TextView>(R.id.secret_word_text_view)
        showSecretWordCheckBox = findViewById<CheckBox>(R.id.show_secret_word_checkbox)
        inputWordEditTextView = findViewById<EditText>(R.id.input_word_edittext_view)
        actionButton = findViewById<Button>(R.id.action_button)
    }

}