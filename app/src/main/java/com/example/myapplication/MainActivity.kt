package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var note: EditText
    private lateinit var btnSave: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        note = findViewById(R.id.editTextTextMultiLine)
        btnSave = findViewById(R.id.btn_save)
        tvResult = findViewById(R.id.tv_result)

        btnSave.setOnClickListener(this)
        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_save) {
            val inputnote = note.text.toString().trim()

            var isEmptyFields = false

            if (inputnote.isEmpty()) {
                isEmptyFields = true
                note.error = "Tidak boleh kosong"
            }

            if (!isEmptyFields) {
                val save = inputnote
                tvResult.text = save
            }
        }
    }
    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }
}