package com.example.mobd_lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

class Video : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_video, container, false)
        val mWebView = view.findViewById(R.id.webViewId) as WebView
        mWebView.loadUrl("https://learnenglish.britishcouncil.org/general-english/video-zone")

        val webSettings = mWebView.getSettings()
        webSettings.setJavaScriptEnabled(true)

        mWebView.setWebViewClient(WebViewClient())

        return view
    }
}

