package com.example.testdemo01;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		//加载本地资源
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/example.html");
        //加载web资源
		webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://baidu.com");
        //手机屏幕自适应
        WebSettings webSettings = webView .getSettings();       
        webSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放
        webSettings.setLoadWithOverviewMode(true);
        //获取手机的信息
        TelephonyManager mTelephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE); 
        String phoneNumber = mTelephonyManager.getLine1Number(); //获取号码
        Log.d("获取本机电话号码--->", phoneNumber); 
        String phoneModel = Build.MODEL;			//获取手机型号
        Log.d("获取手机型号--->", phoneModel);
        @SuppressWarnings("deprecation")
		String phoneSdkVersion = Build.VERSION.SDK;	// 获取SDK版本 
        Log.d("获取SDK版本--->", phoneSdkVersion);
        String phoneReleaseVersion = Build.VERSION.RELEASE; // 获取系统版本
        Log.d("获取手机系统版本-->", phoneReleaseVersion);
	}
	
		
	  private void init(){
	        webView = (WebView) findViewById(R.id.webView);
	        //WebView加载web资源
	       webView.loadUrl("http://baidu.com");
	        //覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
	       webView.setWebViewClient(new WebViewClient(){
	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
	             view.loadUrl(url);
	            return true;
	        }
	       });
	  }
}
