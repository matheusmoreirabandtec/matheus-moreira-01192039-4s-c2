package com.example.continuada_2profyoshi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irSumario(view: View) {
        val telaSumarioCachorros = Intent(this,SumarioCachorros::class.java)
        startActivity(telaSumarioCachorros)
    }

    fun irCadCachorro(view: View) {
        val telaCadastroCachorro = Intent(this,CadastroCachorro::class.java)
        startActivity(telaCadastroCachorro)
    }


}