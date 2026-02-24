package com.example.nodebotdashboard.ui.bot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nodebotdashboard.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class StartupFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_startup, container, false)
        val commandInput = view.findViewById<TextInputEditText>(R.id.etStartupCommand)
        view.findViewById<MaterialButton>(R.id.btnSaveStartup).setOnClickListener {
            Toast.makeText(requireContext(), "Saved: ${commandInput.text}", Toast.LENGTH_SHORT).show()
        }
        return view
    }
}
