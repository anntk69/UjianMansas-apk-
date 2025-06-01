package com.ujianmansas

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.*
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://cbtmansumenep.sch.id/?examkey=NfeFjUc9BWyMXd6KzhhTKnfd3uVcYxzW26C4UvGgr4gXHafTQvSBUrwzvKsRX73bW7pkucGaQiz6xmEb8L2gYPKrwhqZE6M7DMH")

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) webView.goBack() else finish()
            }
        })
    }
}
