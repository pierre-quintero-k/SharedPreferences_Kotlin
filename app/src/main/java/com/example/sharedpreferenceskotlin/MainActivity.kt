package com.example.sharedpreferenceskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.sharedpreferenceskotlin.SharedPreferencesKotlinApplication.Companion.prefs
import com.example.sharedpreferenceskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var et_number : EditText
    private lateinit var tv_number : TextView
    private lateinit var et_text : EditText
    private lateinit var tv_text : TextView
    private lateinit var et_decimal : EditText
    private lateinit var tv_decimal : TextView
    private lateinit var sc_boolean : SwitchCompat
    private lateinit var tv_boolean : TextView
    private lateinit var btn_save : Button
    private lateinit var btn_delete : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        et_number = binding.etNumber
        tv_number = binding.tvNumber
        et_text = binding.etText
        tv_text = binding.tvText
        et_decimal = binding.etDecimal
        tv_decimal = binding.tvDecimal
        sc_boolean = binding.tGbutton
        tv_boolean = binding.tvBoolean
        btn_save = binding.btnSaveValue
        btn_delete = binding.btnDeleteValue

        val number_key = "num_lander"
        val text_key = "text_lander"
        val decimal_key = "decimal_lander"
        val boolean_key = "boolean_lander"

        btn_save.setOnClickListener {
            //Save Data
            var number= et_number.text.toString()
            if(number?.toDoubleOrNull() != null){
                prefs.saveData(number_key, number)
            } else{
                Toast.makeText(this, "debes escribir un numero valido en el campo numero", Toast.LENGTH_SHORT).show()
            }


            var texto= et_text.text.toString()
            if(!texto?.isNullOrEmpty()!!){
                prefs.saveData(text_key, texto)
            } else{
                Toast.makeText(this, "debes escribir un texto valido en el campo texto", Toast.LENGTH_SHORT).show()
            }


            var decimal= et_decimal.text.toString()
            if(decimal?.toDoubleOrNull() != null){
                prefs.saveData(decimal_key, decimal)
            } else{
                Toast.makeText(this, "debes escribir un decimal valido en el campo decimal", Toast.LENGTH_SHORT).show()
            }


            var boolean= sc_boolean.isChecked.toString()
            prefs.saveData(boolean_key, boolean)

            tv_number.text= prefs.getData(number_key)
            tv_text.text= prefs.getData(text_key)
            tv_decimal.text= prefs.getData(decimal_key)
            tv_boolean.text= prefs.getData(boolean_key)
        }

        btn_delete.setOnClickListener {
            prefs.removeData(number_key)
            prefs.removeData(text_key)
            prefs.removeData(decimal_key)
            prefs.removeData(boolean_key)

            tv_number.text= prefs.getData(number_key)
            tv_text.text= prefs.getData(text_key)
            tv_decimal.text= prefs.getData(decimal_key)
            tv_boolean.text= prefs.getData(boolean_key)
        }

    }
}