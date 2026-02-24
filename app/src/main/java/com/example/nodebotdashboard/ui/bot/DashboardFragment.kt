package com.example.nodebotdashboard.ui.bot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nodebotdashboard.R
import com.google.android.material.button.MaterialButton
import kotlin.random.Random

class DashboardFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val status = view.findViewById<TextView>(R.id.tvStatus)
        val ram = view.findViewById<TextView>(R.id.tvRam)
        val disk = view.findViewById<TextView>(R.id.tvDisk)

        fun refreshStats(currentStatus: String) {
            status.text = getString(R.string.status_format, currentStatus)
            ram.text = getString(R.string.ram_usage_format, Random.nextInt(90, 450))
            disk.text = getString(R.string.disk_usage_format, Random.nextInt(300, 4096))
        }

        view.findViewById<MaterialButton>(R.id.btnStart).setOnClickListener { refreshStats("Running") }
        view.findViewById<MaterialButton>(R.id.btnStop).setOnClickListener { refreshStats("Stopped") }
        view.findViewById<MaterialButton>(R.id.btnRestart).setOnClickListener { refreshStats("Restarting") }
        refreshStats("Idle")

        return view
    }

    companion object {
        fun newInstance(botType: String) = DashboardFragment().apply {
            arguments = Bundle().apply { putString("botType", botType) }
        }
    }
}
