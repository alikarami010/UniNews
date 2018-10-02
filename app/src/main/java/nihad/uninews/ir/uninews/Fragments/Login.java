package nihad.uninews.ir.uninews.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.MainActivity;
import nihad.uninews.ir.uninews.Models.Student;
import nihad.uninews.ir.uninews.Models.Uni;
import nihad.uninews.ir.uninews.R;
import nihad.uninews.ir.uninews.WebServices.CallSoap;
import nihad.uninews.ir.uninews.WebServices.CallSoapParametrs;
import nihad.uninews.ir.uninews.WebServices.OperationList;

/**
 * Created by ali on 18/08/2018.
 */

public class Login extends Fragment {
    public static String TAG = "Login";
    Context context;
    Button btnLogin;
    EditText etUser;
    EditText etPass;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login1, container, false);
        Realm myRealm = Realm.getInstance(context);
        myRealm.beginTransaction();
        long count = myRealm.where(Student.class).count();
        myRealm.commitTransaction();
        if (count > 0) {
            myRealm.beginTransaction();
            Common.student = myRealm.where(Student.class).findFirst();
            myRealm.commitTransaction();
            getActivity().startActivity(new Intent(context, MainActivity.class));
        }
        this.btnLogin = view.findViewById(R.id.btnLogin);
        etUser = view.findViewById(R.id.etUser);
        etPass = view.findViewById(R.id.etPass);
        Button btnRegester = view.findViewById(R.id.btnRegester);
        Button btnForgetPass = view.findViewById(R.id.btnForgetPass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsValidData()) {
                    new CallSoapReceive().execute();
                }
            }
        });
        btnRegester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new Regester(), "Regester")
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnForgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ForgetPass(), "ForgetPass")
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

    private boolean IsValidData() {
        boolean state = false;
        if (etUser.getText().toString().trim().length() < 1) {
            etUser.setError("نام کاربری وارد شود");
            return false;
        } else etUser.setError(null);
        if (etPass.getText().toString().length() < 1) {
            etPass.setError("کلمه عبور را وارد نمایید");
            return false;
        } else etPass.setError(null);
        return true;
    }

    private class CallSoapReceive extends AsyncTask<String, Void, String> {

        ProgressBar progressBar;
        String phone_id = "";


        private CallSoapReceive() {

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressBar = new ProgressBar(context);
            this.progressBar.setVisibility(View.VISIBLE);
            this.phone_id = Common.GetIMEI(getActivity());
        }

        @Override
        protected String doInBackground(String... urls) {
            CallSoapParametrs parametrs = new CallSoapParametrs();
            PropertyInfo pi = new PropertyInfo();
            pi.setName("_imei");
            pi.setValue(this.phone_id);
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_iddaneshjo");
            pi.setValue(etUser.getText().toString().trim());
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            parametrs.OPERATION_NAME = OperationList.SelectDaneshjooById;
            return new CallSoap(parametrs).Call();
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(TAG, "result = " + result);
            if (result.length() > 10) {
                Realm myRealm = Realm.getInstance(context);
                try {
                    JSONArray daneshjoo = new JSONObject(result).getJSONArray("ZTblDaneshjo");
                    JSONObject jObject = daneshjoo.getJSONObject(0);
                    Log.i(TAG, "_daneshjopassword=" + jObject.get("_daneshjopassword"));
                    if (jObject.get("_daneshjopassword").equals(etPass.getText().toString())) {
                        myRealm.beginTransaction();
                        myRealm.clear(Student.class);
                        myRealm.createOrUpdateAllFromJson(Student.class, daneshjoo);
                        myRealm.commitTransaction();
                        myRealm.close();
                        myRealm.beginTransaction();
                        Common.student = myRealm.where(Student.class).findFirst();
                        myRealm.commitTransaction();
                        getActivity().startActivity(new Intent(context, MainActivity.class));
                    } else {
                        Toasty.error(context, "متاسفانه نام کاربری یا کلمه عبور اشتباه است").show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toasty.error(context, "متاسفانه ثبت نام  انجام نشده است").show();
                Log.i(TAG, "result = " + result);
            }
            this.progressBar.setVisibility(View.GONE);
        }
    }
}
