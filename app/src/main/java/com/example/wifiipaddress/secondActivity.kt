package com.example.wifiipaddress

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class secondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val btnbck=findViewById<Button>(R.id.button2)
        btnbck.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
    }
}