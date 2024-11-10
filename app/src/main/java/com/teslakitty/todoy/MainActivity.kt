package com.teslakitty.todoy

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the WebView and configure settings
        val webView = findViewById<WebView>(R.id.todoyweb)

        // Set WebViewClient to ensure links open inside the WebView
        webView.webViewClient = WebViewClient()

        // Enable JavaScript (required for interactive sites)
        webView.settings.javaScriptEnabled = true

        // Enable DOM storage and caching for offline use
        webView.settings.domStorageEnabled = true
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT

        // Load the desired URL
        webView.loadUrl("https://todoy1.netlify.app")
    }

    // Override onBackPressed to navigate within the WebView if possible
    override fun onBackPressed() {
        val webView = findViewById<WebView>(R.id.todoyweb)
        if (webView.canGoBack()) {
            webView.goBack() // Navigate back within WebView
        } else {
            super.onBackPressed() // If cannot go back, let the system handle the back press
        }
    }
}
