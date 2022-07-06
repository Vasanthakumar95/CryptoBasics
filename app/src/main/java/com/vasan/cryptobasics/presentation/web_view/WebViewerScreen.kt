package com.vasan.cryptobasics.presentation.web_view

import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WebViewerScreen(
    viewmodel : WebViewViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewmodel.state.value
    Surface(
       modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = {
                WebView(context).apply {
                    settings.javaScriptEnabled = true
                    webViewClient = WebViewClient()
                    webChromeClient = WebChromeClient()
                }
            },
            update = {
                if (state.webLink != ""){
                    it.loadUrl(state.webLink.toString())
                }
                if (state.error != ""){
                    Toast.makeText(context, "Url Not Found", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}