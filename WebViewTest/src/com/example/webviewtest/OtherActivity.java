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
	 * ���ƣ�onCreate <br/>
	 * ������TODO <br/>
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
        //myTextView.setText("��Ʒ����:"+pd+"\n"+"����SDK�汾:"+phoneSdkVersion+"\n"+"ϵͳ�汾:"+phoneReleaseVersion+"\n"+"��ʾ������:"+dis+"\n\n\n"+"��ǰʹ�õ���������:"+non+"\n"+"�豸����:"+device+"\n"+"��������汾��:"+bl+"\n"+"�豸ID:"+diId+"\n\n\n"+"��������״̬:"+da+"\n"+"�豸��ʶ��:"+ds+"\n"+"�ƶ��ն˵�����:"+nt+"\n"+"SIM��״̬:"+sim+"\n"+"��ǰ�ƶ��ն˵�λ��:"+cs+"\n");
		/*listView = new ListView(this);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
	     */
	    //listView.setOnItemClickListener(new ItemClickListener());//�����Ŀ�ĵ���¼�,������ʾ�б��ÿһ��
	}
	 public void getInfo() {
	        try {
	            StringBuilder strLog = new StringBuilder();
	            Context ctx = this.getApplicationContext();
	   
	            /**
	             * 1.��ȡӦ����Ϣ
	             *
	             * Ҫ���ȡ����Ӧ�������Ϣ�����PackageManager��ApplicationInfo����
	             */
	   
	            // ��ȡӦ������
	            String appName = getAppName(ctx);
	            strLog.append("Ӧ������:" + appName + "\r\n");
	   
	            // ��ȡӦ�ð�����
	            String packName = getPackName(ctx);
	            strLog.append("Ӧ�ð�����:" + packName + "\r\n");
	   
	            // ��ȡӦ�ð汾
	            String verName = getVerName(ctx, packName);
	            strLog.append("Ӧ�ð汾����:" + verName + "\r\n");
	   
	            // ��ȡӦ�ð汾��
	            int verCode = getVerCode(ctx, packName);
	            strLog.append("Ӧ�ð汾��:" + verCode + "\r\n");
	   
	            /**
	             * 2.��ȡ�豸��Ϣ
	             */
	            // ��ȡ�ֻ��ͺ�
	            String model = getPhoneModel();
	            strLog.append("�ֻ��ͺ�:" + model + "\r\n");
	   
	            // ��ȡ�ֻ�����
	            String phoneNum = getLineNum(ctx);
	            strLog.append("�ֻ�����:" + phoneNum + "\r\n");
	   
	            // ��ȡ�ƶ��û���־��IMSI
	            String imsi = getSubscriberId(ctx);
	            strLog.append("IMSI:" + imsi + "\r\n");
	   
	            // ��ȡ�豸ID
	            String devID = getDeviceID(ctx);
	            strLog.append("�豸ID:" + devID + "\r\n");
	   
	            // ��ȡSIM����
	            String sim = getSim(ctx);
	            strLog.append("SIM����:" + sim + "\r\n");
	   
	            // ��ȡ��վ��Ϣ
	            SCell cellInfo = getCellInfo(ctx);
	            String strCell = "";
	            if (cellInfo != null) {
	                strCell = cellInfo.toJSON().toString();
	            }
	            strLog.append("��վ��Ϣ:" + strCell + "\r\n");
	   
	            // ��ȡMac��ַ
	            String mac = getMac(ctx);
	            strLog.append("Mac��ַ:" + mac + "\r\n");
	   
	            System.out.println(strLog.toString());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	   
	    /**
	     * ��ȡӦ�ð�����
	     */
	    public String getPackName(Context ctx) {
	        return ctx.getPackageName();
	    }
	   
	    /**
	     * ��ȡӦ�ð汾����
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
	     * ��ȡӦ�ð汾��
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
	     * ��ȡӦ������
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
	     * ��ȡ�ֻ��ͺ�
	     *
	     * android.os.Build�ṩ������Ϣ��
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
	     * ��ȡ�ֻ����룬һ���ȡ����
	     *
	     * �õ���Ȩ�ޣ�
	     *  <uses-permission android:name="android.permission.READ_PHONE_STATE" />
	     *
	     * Ҫ���ȡ����绰�����ݡ��ƶ����������Ϣ�����TelephonyManager����
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
	     * ��ȡ�ƶ��û���־��IMSI
	     *
	     * �õ���Ȩ�ޣ�
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
	     * ��ȡ�豸ID
	     *
	     * �õ���Ȩ�ޣ�
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
	     * ��ȡSIM����
	     *
	     * �õ���Ȩ�ޣ�
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
	     * ��ȡWifi Mac��ַ
	     *
	     * Ҫ���ȡ����Wifi�����Ϣ�����WifiInfo����
	     *
	     * �õ���Ȩ�ޣ�
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
	     * ��ȡ��վ��Ϣ
	     *
	     * �õ���Ȩ�ޣ�
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
	        // IMSI��ǰ��3λ460�ǹ��ң������ź���2λ00 02���й��ƶ���01���й���ͨ��03���й����š�
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
	     * ��վ��Ϣ
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









	 /**      * �����Ŀ�ĵ���¼� 
	     */  
	   /*private final class ItemClickListener implements OnItemClickListener{  
	  
	        *//** 
         * view:��ǰ�������Ŀ��view���� 
	        * position:��ǰ���������Ŀ�����󶨵������ڼ����е�����ֵ 
	         *//*  
        public void onItemClick(AdapterView<?> parent, View view, int position,  
	                long id) {  
	            ListView lView = (ListView) parent;  
	            ���show3()����ʾ 
	            Person person = (Person) lView.getItemAtPosition(position); 
	           Toast.makeText(getApplicationContext(), person.getName(), 
	                   Toast.LENGTH_SHORT).show();  
	           //���show2����ʾ  
            Cursor cursor = (Cursor) lView.getItemAtPosition(position);  
	            Toast.makeText(getApplicationContext(), cursor.getString(cursor.getColumnIndex("name")),  
	                    Toast.LENGTH_SHORT).show();  
	        }  */
        /** 
            * ʹ�ô����α�ļ���������ʾ��Ŀ�б� 
          */  
       /*  private void show2() {  
            Cursor cursor = personService.getCursorScrollData(0, 20);  
              //ʹ��CursorAdapter�ڲ�ѯ����������б���Ҫ��һ��"_id"���ֶ�,����û������  
               *//** 
                * ��һ�ַ���:���ӻ��޸����ݵ��ֶ�ʹ������һ��"_id"���ֶ� 
                 * �ڶ��ַ���:�޸Ĳ�ѯ���,ʹ�ñ�����ʽ 
              *//*  
               CursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.item, cursor,   
                       new String[]{"_id", "name", "age"}, new int[]{R.id.id, R.id.name, R.id.age});  
               listView.setAdapter(adapter);  
           }  

	    }*/  
/*    private List<String> getData(){
        
        List<String> data = new ArrayList<String>();
        data.add("��������1");
        data.add("��������2");
        data.add("��������3");
        data.add("��������4");
         
        return data;
    }*/

