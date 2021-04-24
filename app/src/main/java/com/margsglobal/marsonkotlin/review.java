package com.margsglobal.marsonkotlin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class review extends AppCompatActivity {

    private Context mContext;
    private WebView webView;
    private String url = "https://g.page/marson-furniture/review?rc";

    private String currentUrl = "https://g.page/marson-furniture/review?rc";

    private ValueCallback<Uri[]> mUploadMessage;

    private final static int FILECHOOSER_RESULTCODE = 190;



    private Button reviewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review);

        webView = findViewById(R.id.reviewpage);

        startWebView(url);


    }


    @SuppressLint("SetJavaScriptEnabled")
    private void startWebView(String url) {

        //Create new webview Client to show progress dialog
        //When opening a url or click on link





        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {

                if (mUploadMessage != null) {
                    mUploadMessage.onReceiveValue(null);
                }

                mUploadMessage = filePathCallback;

                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.addCategory(Intent.CATEGORY_OPENABLE);
                i.setType("*/*");

                startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);

                return true;




            }


        });

        // Javascript inabled on webview
        webView.getSettings().setJavaScriptEnabled(true);

        // Other webview options
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.getSettings().setAllowContentAccess(true);

        webView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        currentUrl = url;
        //Load url in webview
        webView.loadUrl(url);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage || intent == null || resultCode != RESULT_OK) {
                return;
            }
            Uri[] result = null;
            String dataString = intent.getDataString();
            if (dataString != null) {
                result = new Uri[]{Uri.parse(dataString)};
            }
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }


    }

}
