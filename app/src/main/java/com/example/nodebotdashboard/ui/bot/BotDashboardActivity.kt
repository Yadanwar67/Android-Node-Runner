package com.example.nodebotdashboard.ui.bot

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.nodebotdashboard.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class BotDashboardActivity : AppCompatActivity() {
    private val tabs = listOf("Dashboard", "StartUp", "Modules", "Network", "Explorer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bot_dashboard)

        val botType = intent.getStringExtra("botType") ?: "JavaScript"
        title = "$botType Bot"

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = tabs.size
            override fun createFragment(position: Int) = when (position) {
                0 -> DashboardFragment.newInstance(botType)
                1 -> StartupFragment()
                2 -> ModulesFragment()
                3 -> NetworkFragment()
                else -> ExplorerFragment()
            }
        }

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }
}
