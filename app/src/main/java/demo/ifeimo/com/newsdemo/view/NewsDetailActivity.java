package demo.ifeimo.com.newsdemo.view;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;

import demo.ifeimo.com.newsdemo.R;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Wing on 2018/4/11.
 */

public class NewsDetailActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolBarLayout;
    private WebView webView;
    private ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        initContent();
    }

    private void initContent() {
        toolbar.setTitle("新闻详情");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        Bundle bundle = this.getIntent().getExtras();
        final ArrayList<String> data = bundle.getStringArrayList("data");
        Log.d("url", data.get(1));
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSettings.setLoadWithOverviewMode(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.loadUrl(data.get(1));
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webView.getSettings().setBlockNetworkImage(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.getSettings().setBlockNetworkImage(false);
            }
        });

        Glide.with(this).load(data.get(0)).error(R.drawable.img_background).fitCenter().into(ivImage);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        webView = (WebView) findViewById(R.id.web_text);
        ivImage = (ImageView) findViewById(R.id.ivImage);
    }
}
