package ru.yandex.practicum.sprint09koh11

import android.app.Activity
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    companion object {
        var themeId: Int = R.style.Theme_Sprint09koh11_Version2

        fun method() {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(themeId)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.theme_1).apply {
            Log.d("SPRINT_9", "findViewById<Button>(R.id.theme_1) $this")

        }.setOnClickListener {
            themeId = R.style.Theme_Sprint09koh11
            recreate()
        }
        findViewById<Button>(R.id.theme_2).setOnClickListener {
            themeId = R.style.Theme_Sprint09koh11_Version2
            recreate()
        }



        val editText = findViewById<EditText>(R.id.edit_text)
        editText.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        editText.postDelayed({
            editText.showKeyboard()
        }, 2000)
//        editText.addTextChangedListener(object :TextWatcher {
//            var isInEditableMode : Boolean = false
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//               Log.d("SPRINT_9", "beforeTextChanged $s $start $count $after")
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                Log.d("SPRINT_9", "onTextChanged $s $start $before $count")
//            }
//
//            override fun afterTextChanged(s: Editable?) {
//                Log.d("SPRINT_9", "afterTextChanged $s")
//                if (isInEditableMode){
//
//                } else {
//                    if (s?.length == 4){
//                        isInEditableMode = true
//                        s?.insert(1, " ")
//                        isInEditableMode = false
//                    }
//                }
//            }
//
//        })

        val darkTheme = findViewById<SwitchCompat>(R.id.dark_theme)

        darkTheme.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
        darkTheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES
                )
            } else {

                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }



    }

    fun method(arg : String?){
        if (arg == null) {
            return
        }
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
        //..
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}

fun View.showKeyboard() {
    requestFocus()
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun showKeyboardWithDelay(view: View, delay: Long = 200) {
    val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    view.postDelayed(object : Runnable {
        override fun run() {
            view.requestFocus()
            imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }, delay)
}

fun Activity.hideKeyboard() {
    val view = this.currentFocus ?: View(this)
    view.hideKeyboard()
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    imm?.hideSoftInputFromWindow(this.windowToken, 0)
}