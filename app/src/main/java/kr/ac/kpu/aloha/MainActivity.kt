package kr.ac.kpu.aloha

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        logo.setOnClickListener {
            val homeIntent = Intent(this, homeActivity::class.java)
          //  Timer("SettingUp", false).schedule(2500) {
                startActivity(homeIntent)
         //   }
        }
        */

    }
}