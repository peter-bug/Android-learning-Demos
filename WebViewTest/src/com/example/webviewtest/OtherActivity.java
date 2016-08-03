package com.example.webviewtest;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.widget.TextView;

public class OtherActivity extends Activity{
	 //private ListView listView;
	 /*private String phoneNumber;
	 private String phoneModel;
	 private String phoneReleaseVersion;
	 private String phoneSdkVersion;
	 private TextView myTextView;*/
	
	/**
	 * 名称：onCreate <br/>
	 * 描述：TODO <br/>
	 * @param savedInstanceState
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	*/

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.other_main);
		getInfo();
        
        
        
        //myTextView=(TextView)findViewById(R.id.mTextView);
        //myTextView.setText("产品名称:"+pd+"\n"+"本机SDK版本:"+phoneSdkVersion+"\n"+"系统版本:"+phoneReleaseVersion+"\n"+"显示屏参数:"+dis+"\n\n\n"+"当前使用的网络类型:"+non+"\n"+"设备参数:"+device+"\n"+"启动程序版本号:"+bl+"\n"+"设备ID:"+diId+"\n\n\n"+"数据连接状态:"+da+"\n"+"设备标识符:"+ds+"\n"+"移动终端的类型:"+nt+"\n"+"SIM卡状态:"+sim+"\n"+"当前移动终端的位置:"+cs+"\n");
		/*listView = new ListView(this);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
	     */
	    //listView.setOnItemClickListener(new ItemClickListener());//针对条目的点击事件,就是显示列表的每一行
	}
	 public void getInfo() {
	        try {
	            StringBuilder strLog = new StringBuilder();
	            Context ctx = this.getApplicationContext();
	   
	            /**
	             * 1.获取应用信息
	             *
	             * 要想获取更多应用相关信息请查阅PackageManager、ApplicationInfo资料
	             */
	   
	            // 获取应用名称
	            String appName = getAppName(ctx);
	            strLog.append("应用名称:" + appName + "\r\n");
	   
	            // 获取应用包名称
	            String packName = getPackName(ctx);
	            strLog.append("应用包名称:" + packName + "\r\n");
	   
	            // 获取应用版本
	            String verName = getVerName(ctx, packName);
	            strLog.append("应用版本名称:" + verName + "\r\n");
	   
	            // 获取应用版本号
	            int verCode = getVerCode(ctx, packName);
	            strLog.append("应用版本号:" + verCode + "\r\n");
	   
	            /**
	             * 2.获取设备信息
	             */
	            // 获取手机型号
	            String model = getPhoneModel();
	            strLog.append("手机型号:" + model + "\r\n");
	   
	            // 获取手机号码
	            String phoneNum = getLineNum(ctx);
	            strLog.append("手机号码:" + phoneNum + "\r\n");
	   
	            // 获取移动用户标志，IMSI
	            String imsi = getSubscriberId(ctx);
	            strLog.append("IMSI:" + imsi + "\r\n");
	   
	            // 获取设备ID
	            String devID = getDeviceID(ctx);
	            strLog.append("设备ID:" + devID + "\r\n");
	   
	            // 获取SIM卡号
	            String sim = getSim(ctx);
	            strLog.append("SIM卡号:" + sim + "\r\n");
	   
	            // 获取基站信息
	            SCell cellInfo = getCellInfo(ctx);
	            String strCell = "";
	            if (cellInfo != null) {
	                strCell = cellInfo.toJSON().toString();
	            }
	            strLog.append("基站信息:" + strCell + "\r\n");
	   
	            // 获取Mac地址
	            String mac = getMac(ctx);
	            strLog.append("Mac地址:" + mac + "\r\n");
	   
	            System.out.println(strLog.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    /**
	     * 获取应用包名称
	     */
	    public String getPackName(Context ctx) {
	        return ctx.getPackageName();
	    }
	   
	    /**
	     * 获取应用版本名称
	     */
	    public String getVerName(Context ctx, String packName) {
	        String verName = "";
	        try {
	            verName = ctx.getPackageManager().getPackageInfo(packName, 0).versionName;
	        } catch (NameNotFoundException e) {
	        }
	        return verName;
	    }
	   
	    /**
	     * 获取应用版本号
	     */
	    public int getVerCode(Context context, String packName) {
	        int versionCode = 0;
	        try {
	            versionCode = context.getPackageManager().getPackageInfo(packName,
	                    0).versionCode;
	        } catch (NameNotFoundException e) {
	        }
	        return versionCode;
	    }
	   
	    /**
	     * 获取应用名称
	     */
	    public String getAppName(Context ctx) {
	        String appName = "";
	        try {
	            PackageManager packManager = ctx.getPackageManager();
	            ApplicationInfo appInfo = ctx.getApplicationInfo();
	            appName = (String) packManager.getApplicationLabel(appInfo);
	        } catch (Exception e) {
	        }
	        return appName;
	    }
	   
	    /**
	     * 获取手机型号
	     *
	     * android.os.Build提供以下信息：
	     *      String  BOARD   The name of the underlying board, like "goldfish".
	     *      String  BRAND   The brand (e.g., carrier) the software is customized for, if any.  
	     *      String  DEVICE  The name of the industrial design.  
	     *      String  FINGERPRINT     A string that uniquely identifies this build.  
	     *      String  HOST        
	     *      String  ID  Either a changelist number, or a label like "M4-rc20".  
	     *      String  MODEL   The end-user-visible name for the end product.  
	     *      String  PRODUCT     The name of the overall product.        
	     *      String  TAGS    Comma-separated tags describing the build, like "unsigned,debug".      
	     *      long    TIME            
	     *      String  TYPE    The type of build, like "user" or "eng".        
	     *      String  USER    
	     */
	    public String getPhoneModel() {
	        return android.os.Build.MODEL;
	    }
	   
	    /**
	     * 获取手机号码，一般获取不到
	     *
	     * 用到的权限：
	     *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     *
	     * 要想获取更多电话、数据、移动网络相关信息请查阅TelephonyManager资料
	     */
	    public String getLineNum(Context ctx) {
	        String strResult = "";
	        TelephonyManager telephonyManager = (TelephonyManager) ctx
	                .getSystemService(Context.TELEPHONY_SERVICE);
	        if (telephonyManager != null) {
	            strResult = telephonyManager.getLine1Number();
	        }
	        return strResult;
	    }
	   
	    /**
	     * 获取移动用户标志，IMSI
	     *
	     * 用到的权限：
	     *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     */
	    public String getSubscriberId(Context ctx) {
	        String strResult = "";
	        TelephonyManager telephonyManager = (TelephonyManager) ctx
	                .getSystemService(Context.TELEPHONY_SERVICE);
	        if (telephonyManager != null) {
	            strResult = telephonyManager.getSubscriberId();
	        }
	        return strResult;
	    }
	   
	    /**
	     * 获取设备ID
	     *
	     * 用到的权限：
	     *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     */
	    public String getDeviceID(Context ctx) {
	        String strResult = null;
	        TelephonyManager telephonyManager = (TelephonyManager) ctx
	                .getSystemService(Context.TELEPHONY_SERVICE);
	        if (telephonyManager != null) {
	            strResult = telephonyManager.getDeviceId();
	        }
	        if (strResult == null) {
	            strResult = Secure.getString(ctx.getContentResolver(),
	                    Secure.ANDROID_ID);
	        }
	        return strResult;
	    }
	   
	    /**
	     * 获取SIM卡号
	     *
	     * 用到的权限：
	     *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     */
	    public String getSim(Context ctx) {
	        String strResult = "";
	        TelephonyManager telephonyManager = (TelephonyManager) ctx
	                .getSystemService(Context.TELEPHONY_SERVICE);
	        if (telephonyManager != null) {
	            strResult = telephonyManager.getSimSerialNumber();
	        }
	        return strResult;
	    }
	   
	    /**
	     * 获取Wifi Mac地址
	     *
	     * 要想获取更多Wifi相关信息请查阅WifiInfo资料
	     *
	     * 用到的权限：
	     *  <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	     */
	    public String getMac(Context ctx) {
	   
	        WifiManager wifiManager = (WifiManager) ctx
	                .getSystemService(Context.WIFI_SERVICE);
	        if (wifiManager != null) {
	            WifiInfo wi = wifiManager.getConnectionInfo();
	            return wi.getMacAddress();
	        }
	        return null;
	    }
	   
	    /**
	     * 获取基站信息
	     *
	     * 用到的权限：
	     * <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     * <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
	     */
	    public SCell getCellInfo(Context ctx) {
	        SCell cell = new SCell();
	        TelephonyManager tm = null;
	        try {
	            tm = (TelephonyManager) ctx
	                    .getSystemService(Context.TELEPHONY_SERVICE);
	        } catch (Exception e) {
	            return null;
	        }
	        // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
	        String IMSI = tm.getSubscriberId();
	   
	        if (IMSI != null) {
	            if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
	                cell.NETWORK_TYPE = "CHINA MOBILE";
	   
	                GsmCellLocation location = (GsmCellLocation) tm
	                        .getCellLocation();
	                if (location == null) {
	                    cell = null;
	                } else {
	                    String operator = tm.getNetworkOperator();
	                    if (operator.length() > 4) {
	                        int mcc = Integer.parseInt(operator.substring(0, 3));
	                        int mnc = Integer.parseInt(operator.substring(3));
	                        int cid = location.getCid();
	                        int lac = location.getLac();
	   
	                        cell.MCC = mcc;
	                        cell.MNC = mnc;
	                        cell.LAC = lac;
	                        cell.CID = cid;
	                    } else {
	                        cell = null;
	                    }
	                }
	            } else if (IMSI.startsWith("46001")) {
	                cell.NETWORK_TYPE = "CHINA UNICOM";
	   
	                GsmCellLocation location = (GsmCellLocation) tm
	                        .getCellLocation();
	                if (location == null) {
	                    cell = null;
	                } else {
	                    String operator = tm.getNetworkOperator();
	                    if (operator.length() > 4) {
	                        int mcc = Integer.parseInt(operator.substring(0, 3));
	                        int mnc = Integer.parseInt(operator.substring(3));
	                        int cid = location.getCid();
	                        int lac = location.getLac();
	   
	                        cell.MCC = mcc;
	                        cell.MNC = mnc;
	                        cell.LAC = lac;
	                        cell.CID = cid;
	                    } else {
	                        cell = null;
	                    }
	                }
	            } else if (IMSI.startsWith("46003")) {
	                cell.NETWORK_TYPE = "CHINA TELECOM";
	   
	                CdmaCellLocation location = (CdmaCellLocation) tm
	                        .getCellLocation();
	                if (location == null) {
	                    cell = null;
	                } else {
	                    String operator = tm.getNetworkOperator();
	                    if (operator.length() > 4) {
	                        int mcc = Integer.parseInt(operator.substring(0, 3));
	                        int mnc = Integer.parseInt(operator.substring(3));
	                        int cid = location.getBaseStationId();
	                        int lac = location.getNetworkId();
	   
	                        cell.MCC = mcc;
	                        cell.MNC = mnc;
	                        cell.LAC = lac;
	                        cell.CID = cid;
	                    } else {
	                        cell = null;
	                    }
	                }
	            } else {
	                // cell.NETWORK_TYPE = "UNDENTIFIED";
	                cell = null;
	            }
	        } else {
	            cell = null;
	        }
	        return cell;
	    }
	   
	    /**
	     * 基站信息
	     */
	    class SCell {
	   
	        public String NETWORK_TYPE;
	   
	        public int MCC;
	   
	        public int MNC;
	   
	        public int LAC;
	   
	        public int CID;
	   
	        public JSONObject toJSON() throws JSONException {
	            JSONObject json = new JSONObject();
	            json.put("network_type", NETWORK_TYPE);
	            json.put("mcc", MCC);
	            json.put("MNC", MNC);
	            json.put("LAC", LAC);
	            json.put("CID", CID);
	            return json;
	        }
	    }

}









	 /**      * 针对条目的点击事件 
	     */  
	   /*private final class ItemClickListener implements OnItemClickListener{  
	  
	        *//** 
         * view:当前所点击条目的view对象 
	        * position:当前所点击的条目它所绑定的数据在集合中的索引值 
	         *//*  
        public void onItemClick(AdapterView<?> parent, View view, int position,  
	                long id) {  
	            ListView lView = (ListView) parent;  
	            针对show3()的显示 
	            Person person = (Person) lView.getItemAtPosition(position); 
	           Toast.makeText(getApplicationContext(), person.getName(), 
	                   Toast.LENGTH_SHORT).show();  
	           //针对show2的显示  
            Cursor cursor = (Cursor) lView.getItemAtPosition(position);  
	            Toast.makeText(getApplicationContext(), cursor.getString(cursor.getColumnIndex("name")),  
	                    Toast.LENGTH_SHORT).show();  
	        }  */
        /** 
            * 使用带有游标的简单适配器显示条目列表 
          */  
       /*  private void show2() {  
            Cursor cursor = personService.getCursorScrollData(0, 20);  
              //使用CursorAdapter在查询结果的名称中必须要有一个"_id"的字段,否则没法工作  
               *//** 
                * 第一种方案:增加或修改数据的字段使表中有一个"_id"的字段 
                 * 第二种方案:修改查询语句,使用别名方式 
              *//*  
               CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor,   
                       new String[]{"_id", "name", "age"}, new int[]{R.id.id, R.id.name, R.id.age});  
               listView.setAdapter(adapter);  
           }  

	    }*/  
/*    private List<String> getData(){
        
        List<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");
         
        return data;
    }*/

