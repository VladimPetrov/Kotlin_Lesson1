package ru.gb.kotlin_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import ru.gb.kotlin_lesson1.Domain.GameEngine
import ru.gb.kotlin_lesson1.Utils.findChar

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
        initListener()
    }

    private fun initListener() {
        showSecretWordCheckBox.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                if (showSecretWordCheckBox.isChecked) {
                    secretTextView.text = GameEngine.getSecret()
                } else {
                    secretTextView.text = ""
                }
            }
        })
        actionButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                when(GameEngine.counterRound) {
                    0 -> {
                        GameEngine.incRound()
                        titleTextView.visibility = View.VISIBLE
                        titleTextView.text = "Раунд №" + GameEngine.counterRound.toString()
                        titleTextView.setTextColor(resources.getColor(R.color.title_text_color))
                        setWordTextView.text = GameEngine.storageWords.getListWordToStr()
                        showSecretWordCheckBox.setEnabled(true)
                        showSecretWordCheckBox.setChecked(false)
                        secretTextView.text = ""
                        keyTextView.text = ""
                        inputWordEditTextView.setText("")
                        actionButton.text = resources.getString(R.string.next_button_text)
                    }
                    else -> {
                        if (GameEngine.isVictory(inputWordEditTextView.text.toString())) {
                            titleTextView.text = "Вы выйграли!!!!"
                            actionButton.text = resources.getString(R.string.begin_button_text)
                        } else if (GameEngine.counterRound == 3) {
                            titleTextView.text = "Вы проиграли!!!!"
                            titleTextView.setTextColor(resources.getColor(R.color.red_text_color))
                            actionButton.text = resources.getString(R.string.begin_button_text)
                            showSecretWordCheckBox.setEnabled(false)
                            secretTextView.text = GameEngine.getSecret()
                            GameEngine.counterRound = 0
                        } else {
                            GameEngine.incRound()
                            titleTextView.text = "Раунд №" + GameEngine.counterRound.toString()
                            keyTextView.text = findChar(inputWordEditTextView.text.toString(),GameEngine.getSecret())
                            inputWordEditTextView.setText("")
                        }
                    }
                }
            }
        })
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