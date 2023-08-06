package com.example.wifiipaddress

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Formatter
import android.widget.Button
import android.widget.TextView
import java.text.Format
import android.Manifest
import android.content.Intent
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var tv_IpAddress:TextView?=null
    var tv_ChangeIp:EditText?=null
    var Ip_address:String?=null
    var MainIp:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val wifiManager = application.getSystemService(WIFI_SERVICE) as WifiManager
        if (wifiManager.isWifiEnabled){
            val  wifiState="On"
            Toast.makeText(this, "Wifi is $wifiState", Toast.LENGTH_SHORT).show()

        }
        else{
            val  wifiState="Off"
            Toast.makeText(this, "Wifi is $wifiState", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Please Turn On wifi !", Toast.LENGTH_SHORT).show()
        }




        val btnCheck=findViewById<Button>(R.id.button)
        btnCheck.setOnClickListener {

            tv_IpAddress=findViewById(R.id.Ip_Address)
            var WifiManager=application.getSystemService(WIFI_SERVICE) as WifiManager
            val wifiInfo=WifiManager.connectionInfo
            Ip_address= Formatter.formatIpAddress(wifiInfo.ipAddress)

            Toast.makeText(this, "Your Ip address is $Ip_address", Toast.LENGTH_SHORT).show()
            tv_IpAddress?.text = Ip_address
            tv_ChangeIp = findViewById(R.id.UpdateIpEditText)
            tv_ChangeIp?.setText(Ip_address)
            val info=findViewById<TextView>(R.id.textView)
            info.text="Current WiFi Ip is $Ip_address\n" +
                    "Required Ip is $MainIp\n"

        }

        val updateBtn=findViewById<Button>(R.id.ChangeIp)
        updateBtn.setOnClickListener {
            MainIp= tv_ChangeIp?.text.toString()
        }


        val submitBtn=findViewById<Button>(R.id.Submit)
        submitBtn.setOnClickListener {
            if (Ip_address==MainIp){
                val intent=Intent(this,secondActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Ip not matched", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Required Ip is : $MainIp", Toast.LENGTH_SHORT).show()
                Toast.makeText(this, "Ip Found :$Ip_address", Toast.LENGTH_SHORT).show()


            }
        }


    }




}