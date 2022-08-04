package com.example.morningintentsapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var buttonSms:Button ?= null
    var buttonEmail:Button ?= null
    var buttonCamera:Button ?= null
    var buttonShare:Button ?= null
    var buttonMpesa:Button ?= null
    var buttonCall:Button ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSms=findViewById(R.id.mBtnSms)
        buttonEmail=findViewById(R.id.mBtnEmail)
        buttonCamera=findViewById(R.id.mBtnCamera)
        buttonShare=findViewById(R.id.mBtnShare)
        buttonMpesa=findViewById(R.id.mBtnMpesa)
        buttonCall=findViewById(R.id.mBtnCall)

        buttonSms!!.setOnClickListener {

            val uri = Uri.parse("smsto:YOUR_SMS_NUMBER")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)

        }
          buttonEmail!!.setOnClickListener {
                val emailIntent =
                    Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","abc@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

        }
         buttonCamera !!.setOnClickListener {
             val uri = Uri.parse("smsto:YOUR_SMS_NUMBER")
             val intent = Intent(Intent.ACTION_SENDTO, uri)
             intent.putExtra("sms_body", "The SMS text")
             startActivity(intent)

        }
          buttonShare!!.setOnClickListener {
              val shareIntent = Intent(Intent.ACTION_SEND)
              shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
              shareIntent.type = "text/plain"
              shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
              startActivity(shareIntent)
        }
          buttonMpesa!!.setOnClickListener {
              val simToolKitLaunchIntent =
                  applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
              simToolKitLaunchIntent?.let { startActivity(it) }
        }
          buttonCall!!.setOnClickListener {
              val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+2542222222"))
              if (ContextCompat.checkSelfPermission(
                      this@MainActivity,
                      Manifest.permission.CALL_PHONE
                  ) != PackageManager.PERMISSION_GRANTED
              ) {
//                  request
                  ActivityCompat.requestPermissions(
                      this@MainActivity,
                      arrayOf(Manifest.permission.CALL_PHONE),
                      1
                  )
              } else {
                  startActivity(intent)
              }
        }


    }
}

//  APP with 4 pages
//  1st page= button linking you in three different pages
//  2nd page = calc
//  3rd page = a website
//  4th page = at least six intents




























