package nihad.uninews.ir.uninews.CommonClasses;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import nihad.uninews.ir.uninews.Models.AppSetting;
import nihad.uninews.ir.uninews.Models.Maghta;
import nihad.uninews.ir.uninews.Models.Reshte;
import nihad.uninews.ir.uninews.Models.Student;
import nihad.uninews.ir.uninews.Models.Uni;


public class Common {
    public static int AppVersion = 13970610;
    public static int BUFFER_SIZE = 1024;
    public static int CurrentN_Id = 0;
    public static Stack<Activity> CurrentPage = new Stack();
    public static int DescLenght = 50;
    public static int ExpireDate = 13960231;
    public static String MoneyUnit = "ریال";
    public static String MoneyUnitToman = "تومان";
    public static int SelectedMenu = -1;
    private static final String TAG = "Common";
    public static int dbVersion = 13941205;
    public static String PhoneNumber = "30002283444444";
    public static String AppTempFolder = "/sdcard/TempPaymanyar/";
    public static AppSetting setting;
    public static Student student;

    public boolean CheckLogin() {
        return true;
    }

    public static String ChangeToCurrency(String str) {
        if (str.length() == 0) {
            return "0";
        }
        String txt = ChangeToNumberic(str);
        String num = "";
        int counter = 0;
        for (int i = txt.length() - 1; i >= 0; i--) {
            if (num.length() > 2 && counter % 3 == 0) {
                num = "," + num;
            }
            num = txt.substring(i, i + 1) + num;
            counter++;
        }
        if (str.substring(0, 1).equals("-")) {
            return "-" + num;
        }
        return num;
    }

    public static String RemoveNonCharacter(String str) {
        Log.i(TAG, "RemoveNonCharacter Str = " + str);
        String txt = "";
        for (int i = 0; i < str.length(); i++) {
            char chr = str.substring(i, i + 1).charAt(0);
            if ((chr >= 'A' && chr <= 'Z') || ((chr >= 'a' && chr <= 'z') || ((chr >= 'ا' && chr <= 'ی') || ((chr >= '0' && chr <= '9') || (chr >= '۰' && chr <= '۹'))))) {
                txt = txt + chr;
            }
        }
        return txt;
    }

    public static String ChangeToNumberic(String str) {
        String txt = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            try {
                txt = txt + Integer.parseInt(str.substring(i, i + 1));
            } catch (Exception e) {
            }
        }
        return txt;
    }

    public static String GetEnString(String str) {
        for (int i = 0; i < str.length(); i++) {
        }
        return "";
    }

    public static int TryParseInt(String someText) {
        Log.i(TAG, "TryParseInt = " + someText);
        try {
            return Integer.parseInt(ChangeToNumberic(someText));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
    public static long TryParseLong(String someText) {
        Log.i(TAG, "TryParseLong = " + someText);
        try {
            return Long.parseLong(ChangeToNumberic(someText));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String DateToFormat(String date) {
        if (date.length() < 8) {
            return "";
        }
        char[] val = date.toCharArray();
        return String.copyValueOf(val, 0, 4) + "/" + String.copyValueOf(val, 4, 2) + "/" + String.copyValueOf(val, 6, 2);
    }

    public static String GetIMEI(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            return ((TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        }
        return null;
    }

    public static void copyFile(String srcPath, String dstPath) throws IOException {
        Log.i(TAG, "from : " + srcPath);
        Log.i(TAG, "to : " + dstPath);
        File sourceLocation = new File(srcPath);
        File targetLocation = new File(dstPath);
        File dir = new File(dstPath.substring(0, dstPath.lastIndexOf("/")));
        Log.i(TAG, dir.getPath());
        try {
            if (!dir.isDirectory())
                dir.mkdirs();
            if (sourceLocation.exists()) {

                InputStream in = new FileInputStream(sourceLocation);
                OutputStream out = new FileOutputStream(targetLocation);

                byte[] buf = new byte[1024];
                int len;


                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();

                Log.v(TAG, "Copy file successful.");

            } else {
                Log.v(TAG, "Copy file failed. Source file missing.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void zip(String[] files, String zipFile) throws IOException {
        BufferedInputStream origin = null;
        ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(zipFile)));
        try {
            byte data[] = new byte[BUFFER_SIZE];

            for (int i = 0; i < files.length; i++) {
                FileInputStream fi = new FileInputStream(files[i]);
                origin = new BufferedInputStream(fi, BUFFER_SIZE);
                try {
                    ZipEntry entry = new ZipEntry(files[i].substring(files[i]
                            .lastIndexOf("/") + 1));
                    out.putNextEntry(entry);
                    int count;
                    while ((count = origin.read(data, 0, BUFFER_SIZE)) != -1) {
                        out.write(data, 0, count);
                    }
                } finally {
                    origin.close();
                }
            }
        } finally {
            out.close();
        }
    }


    public static Point getScreenSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        try {
            display.getSize(size);
        } catch (NoSuchMethodError err) {
            Log.i(TAG, "cannot read size");
        }
        return new Point(size.x, size.y);
    }

    public static int dpToPx(float dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }


    public static void ShareFile(Activity activity, String path) {
        try {
            Log.i(TAG, "path of share file : " + path);
//            final String appName = "org.telegram.messenger";
            PackageManager pm = activity.getPackageManager();
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SEND_MULTIPLE);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Here are some files.");
//            intent.setType("application/vnd.android.package-archive");
            intent.setType("*/*");
//            intent.setPackage(appName);
            ArrayList<Uri> files = new ArrayList<Uri>();
            File file = new File(path);
            Uri uri = Uri.fromFile(file);
            files.add(uri);
            intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, files);
            activity.startActivity(intent);
        } catch (Exception e) {
            Log.e("ShareApp", e.getMessage());
        }
    }

    public static void LoadAppSetting(Context context) {

        Realm myRealm = Realm.getInstance(context);
        myRealm.beginTransaction();
        setting = myRealm.where(AppSetting.class).findFirst();
        myRealm.commitTransaction();
        if (setting == null) {
            setting = new AppSetting();
            setting.setID(1);
            setting.setReadMessages(true);
            setting.setNewMessageCount(0);
            setting.setToday("-1");
            myRealm.beginTransaction();
            setting = myRealm.copyToRealmOrUpdate(setting);
            myRealm.commitTransaction();
        }
    }

    public static boolean chkInternetConnection(Context context) {

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else {
            Toasty.error(context, "دستگاه شما به اینترنت متصل نمی باشد").show();
            connected = false;
        }
        return connected;
    }
    public static String[] getUniList(Context context) {

        Realm myRealm = Realm.getInstance(context);
        List<Uni> unis = myRealm.allObjects(Uni.class);
        String all[] = new String[unis.size() + 1];
        all[0] = "";
        for (int i = 1; i <= unis.size(); i++) {
            all[i] = unis.get(i - 1).getGId()+"-"+unis.get(i - 1).getGNamDaneshgah();
            Log.i(TAG, all[i]);
        }
        myRealm.close();
        return all;
    }
    public static String[] getReshteList(Context context) {

        Realm myRealm = Realm.getInstance(context);
        List<Reshte> reshtes = myRealm.allObjects(Reshte.class);
        String all[] = new String[reshtes.size() + 1];
        all[0] = "";
        for (int i = 1; i <= reshtes.size(); i++) {
            all[i] =reshtes.get(i - 1).getReshteId()+"-"+ reshtes.get(i - 1).getReshteNam();
            Log.i(TAG, all[i]);
        }
        myRealm.close();
        return all;
    }
    public static String[] getMaghtaList(Context context) {

        Realm myRealm = Realm.getInstance(context);
        List<Maghta> maghtas = myRealm.allObjects(Maghta.class);
        String all[] = new String[maghtas.size() + 1];
        all[0] = "";
        for (int i = 1; i <= maghtas.size(); i++) {
            all[i] = maghtas.get(i - 1).getMaqtaeID()+"-"+maghtas.get(i - 1).getMaqtaeNam();
            Log.i(TAG, all[i]);
        }
        myRealm.close();
        return all;
    }
}
