package com.example.nodebotdashboard.ui.about

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nodebotdashboard.BuildConfig
import com.example.nodebotdashboard.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        findViewById<TextView>(R.id.tvAboutText).text =
            getString(R.string.about_body, BuildConfig.VERSION_NAME)
    }
}
