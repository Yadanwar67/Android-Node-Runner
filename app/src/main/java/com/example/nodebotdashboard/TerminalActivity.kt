package com.example.nodebotdashboard

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nodebotdashboard.runtime.NodeRuntime
import com.google.android.material.button.MaterialButton
import java.io.BufferedReader
import java.io.InputStreamReader

class TerminalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terminal)

        val output = findViewById<TextView>(R.id.tvTerminalOutput)
        val input = findViewById<EditText>(R.id.etTerminalInput)

        findViewById<MaterialButton>(R.id.btnStartNode).setOnClickListener {
            NodeRuntime.startEmbeddedHttpServer()
            output.append("\n[system] Embedded Node runtime started on 127.0.0.1:3000\n")
        }

        findViewById<MaterialButton>(R.id.btnRunCommand).setOnClickListener {
            val command = input.text.toString().trim()
            if (command.isEmpty()) return@setOnClickListener
            output.append("$ $command\n")
            Thread {
                val result = runCommand(command)
                runOnUiThread { output.append("$result\n") }
            }.start()
            input.text?.clear()
        }
    }

    private fun runCommand(command: String): String = try {
        val process = ProcessBuilder("sh", "-c", command).redirectErrorStream(true).start()
        BufferedReader(InputStreamReader(process.inputStream)).use { it.readText() }
    } catch (e: Exception) {
        "Error: ${e.message}"
    }
}
