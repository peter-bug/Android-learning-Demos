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
		//���ر�����Դ
        //webView = (WebView) findViewById(R.id.webView);
        //webView.loadUrl("file:///android_asset/example.html");
        //����web��Դ
		webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://baidu.com");
        //�ֻ���Ļ����Ӧ
        WebSettings webSettings = webView .getSettings();       
        webSettings.setUseWideViewPort(true);//���ô����ԣ��������������
        webSettings.setLoadWithOverviewMode(true);
        //��ȡ�ֻ�����Ϣ
        TelephonyManager mTelephonyManager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE); 
        String phoneNumber = mTelephonyManager.getLine1Number(); //��ȡ����
        Log.d("��ȡ�����绰����--->", phoneNumber); 
        String phoneModel = Build.MODEL;			//��ȡ�ֻ��ͺ�
        Log.d("��ȡ�ֻ��ͺ�--->", phoneModel);
        @SuppressWarnings("deprecation")
		String phoneSdkVersion = Build.VERSION.SDK;	// ��ȡSDK�汾 
        Log.d("��ȡSDK�汾--->", phoneSdkVersion);
        String phoneReleaseVersion = Build.VERSION.RELEASE; // ��ȡϵͳ�汾
        Log.d("��ȡ�ֻ�ϵͳ�汾-->", phoneReleaseVersion);
	}
	
		
	  private void init(){
	        webView = (WebView) findViewById(R.id.webView);
	        //WebView����web��Դ
	       webView.loadUrl("http://baidu.com");
	        //����WebViewĬ��ʹ�õ�������ϵͳĬ�����������ҳ����Ϊ��ʹ��ҳ��WebView��
	       webView.setWebViewClient(new WebViewClient(){
	           @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            // TODO Auto-generated method stub
	               //����ֵ��true��ʱ�����ȥWebView�򿪣�Ϊfalse����ϵͳ�����������������
	             view.loadUrl(url);
	            return true;
	        }
	       });
	  }
}
