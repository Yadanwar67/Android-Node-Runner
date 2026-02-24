package com.example.nodebotdashboard.ui.bot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.nodebotdashboard.R
import com.google.android.material.button.MaterialButton

class ModulesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_modules, container, false)
        val output = view.findViewById<TextView>(R.id.tvModulesOutput)
        view.findViewById<MaterialButton>(R.id.btnInstallModules).setOnClickListener {
            output.text = "npm install / pip install executed (placeholder)."
        }
        return view
    }
}
