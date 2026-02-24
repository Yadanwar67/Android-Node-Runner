package com.example.nodebotdashboard.ui.bot

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nodebotdashboard.R
import com.google.android.material.button.MaterialButton

class BotTypeSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_type)

        val botType = intent.getStringExtra("botType") ?: "JavaScript"
        findViewById<TextView>(R.id.tvBotTypeTitle).text = getString(R.string.bot_dashboard_title, botType)

        findViewById<MaterialButton>(R.id.btnOpenDashboard).setOnClickListener {
            startActivity(Intent(this, BotDashboardActivity::class.java).putExtra("botType", botType))
        }
    }
}
