package com.example.webview

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings.LOAD_DEFAULT
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var webViewVariable:WebView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webViewVariable = findViewById(R.id.webView)

        webViewSetup(webViewVariable)


    }

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(webView: WebView){

        webView.webViewClient = WebViewClient()

        webView.apply {

            settings.javaScriptEnabled = true

            settings.safeBrowsingEnabled = true

            settings.domStorageEnabled = true




            loadUrl("https://99designs.com/inspiration/websites/simple")

        }
    }

    override fun onBackPressed() {
        // Check if WebView can go back in its history
        if (webViewVariable.canGoBack()) {
            webViewVariable.goBack()
        } else {
            // If WebView cannot go back, perform the default back button action
            super.onBackPressed()
        }


    }

}