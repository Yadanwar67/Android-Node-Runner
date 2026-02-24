package com.example.nodebotdashboard

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nodebotdashboard.ui.about.AboutActivity
import com.example.nodebotdashboard.ui.bot.BotTypeSelectionActivity
import com.example.nodebotdashboard.ui.settings.SettingsActivity
import com.google.android.material.button.MaterialButton

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        findViewById<MaterialButton>(R.id.btnTerminal).setOnClickListener {
            startActivity(Intent(this, TerminalActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnAddJsBot).setOnClickListener {
            startActivity(Intent(this, BotTypeSelectionActivity::class.java).putExtra("botType", "JavaScript"))
        }
        findViewById<MaterialButton>(R.id.btnAddPyBot).setOnClickListener {
            startActivity(Intent(this, BotTypeSelectionActivity::class.java).putExtra("botType", "Python"))
        }
        findViewById<MaterialButton>(R.id.btnSettings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        findViewById<MaterialButton>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        findViewById<TextView>(R.id.tvVersion).text = getString(R.string.version_format, BuildConfig.VERSION_NAME)
    }
}
