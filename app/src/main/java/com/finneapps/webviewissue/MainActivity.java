package com.finneapps.webviewissue;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final boolean ADD_STYLES_AFTER_PAGE_LOADED = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webView);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadData(ADD_STYLES_AFTER_PAGE_LOADED ? getHtmlWithNoStylesInHeader() : getHtmlWithHeader(),
                "text/html", "UTF-8");
    }

    private String getHtmlWithNoStylesInHeader() {
        return "<html><head>" + getJavaScript() + "</head><body><p>" + HtmlContent.LOREM + "</p></body" +
               "></html>";
    }

    private String getHtmlWithHeader() {
        return "<html><head>    <style>html\n" + "    {\n" +
               "        margin:0px !important; height:639px!important; padding-top:56px!important;-webkit-column-gap: 0px!important; -webkit-column-width: 412px!important;\n" +
               "    }</style></head><body><p>" + HtmlContent.LOREM + "</p></body></html>";
    }

    private String getJavaScript() {
        return "\n<script type=\"text/javascript\">function setStyles(){document.body.style" +
               ".webkitColumnWidth = \"412px\";document.body.style.height = \"600px\";}</script>\n";
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public void onPageFinished(final WebView view, String url) {
            super.onPageFinished(view, url);
            if (ADD_STYLES_AFTER_PAGE_LOADED) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        view.loadUrl("javascript:setStyles();");
                    }
                });
            }
        }
    }

}
