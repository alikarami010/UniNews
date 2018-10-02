package nihad.uninews.ir.uninews.CommonClasses;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

/**
 * Created by ali on 10/04/2018.
 */

public class Permissions {
    public static boolean chkREAD_PHONE_STATE(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.READ_PHONE_STATE")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.READ_PHONE_STATE"}, 100);
        return false;
    }
    public static boolean chkCALL_PHONE(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.CALL_PHONE") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.CALL_PHONE")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CALL_PHONE"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CALL_PHONE"}, 100);
        return false;
    }
    public static boolean chkWRITE_EXTERNAL_STORAGE(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 100);
        return false;
    }
    public static boolean chkINTERNET(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.INTERNET") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.INTERNET")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.INTERNET"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.INTERNET"}, 100);
        return false;
    }
    public static boolean chkSendSMS(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.SEND_SMS") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.SEND_SMS")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.SEND_SMS"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.SEND_SMS"}, 100);
        return false;
    }
    public static boolean chkNetworkStatus(final Activity activity) {
        Context context = activity.getApplicationContext();
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            return true;
        }
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_NETWORK_STATE")) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setCancelable(true);
            alertBuilder.setTitle((CharSequence) "مجوز فعالیت");
            alertBuilder.setMessage((CharSequence) "جهت اجرای این قسمت نیاز به مجوز می باشد");
            alertBuilder.setPositiveButton("مجوز", new DialogInterface.OnClickListener() {
                @TargetApi(16)
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_NETWORK_STATE"}, 100);
                }
            });
            alertBuilder.create().show();
            return false;
        }
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_NETWORK_STATE"}, 100);
        return false;
    }
}
