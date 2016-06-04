package com.example.hassan.mybrowser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Hassan on 04/06/2016.
 * this class make us able to navigate to any link inside the web page
 */
class MyBrowser extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        MainActivity.pushInHistory();
        MainActivity.setCurrent(url);
        view.loadUrl(url);
        return true;
    }
}
