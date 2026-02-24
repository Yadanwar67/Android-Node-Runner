package com.example.nodebotdashboard.runtime

object NodeRuntime {
    init {
        System.loadLibrary("native-lib")
        System.loadLibrary("node")
    }

    @JvmStatic
    external fun startNodeWithArguments(arguments: Array<String>): Int

    fun startEmbeddedHttpServer() {
        Thread {
            val script = "const http=require('http');const server=http.createServer((req,res)=>res.end('Hello from embedded Node runtime'));server.listen(3000,'127.0.0.1');"
            startNodeWithArguments(arrayOf("node", "-e", script))
        }.start()
    }
}
