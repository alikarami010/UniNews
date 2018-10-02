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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import org.ksoap2.serialization.PropertyInfo;

import es.dmoral.toasty.Toasty;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.MainActivity;
import nihad.uninews.ir.uninews.Models.Student;
import nihad.uninews.ir.uninews.R;
import nihad.uninews.ir.uninews.WebServices.CallSoap;
import nihad.uninews.ir.uninews.WebServices.CallSoapParametrs;
import nihad.uninews.ir.uninews.WebServices.OperationList;
import nihad.uninews.ir.uninews.frmLogin;

/**
 * Created by ali on 18/08/2018.
 */

public class Regester3 extends Fragment {
    public static String TAG = "Regester";
    Context context;
    AutoCompleteTextView acMaghta;
    AutoCompleteTextView acReshte;
    String[] reshte = new String[]{""};
    String[] maghta = new String[]{""};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login4, container, false);
        Button btnNext = view.findViewById(R.id.btnNext);
        acMaghta = view.findViewById(R.id.acMaghta);
        acReshte = view.findViewById(R.id.acReshte);
        ConfigAutoCompeletView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsValidData()) {
                    frmLogin.student.set_daneshjomaqtae(acMaghta.getText().toString().trim());
                    frmLogin.student.set_daneshjoreshte(acReshte.getText().toString().trim());
                    new CallSoapSend(frmLogin.student).execute();
                }
            }
        });
        return view;
    }

    private boolean IsValidData() {
        if (acReshte.getError() != null || acMaghta.getError() != null) {
            return false;
        }
        return true;
    }

    private void ConfigAutoCompeletView() {
        reshte = Common.getReshteList(context);
        maghta = Common.getMaghtaList(context);
        ArrayAdapter adapterReshte = new ArrayAdapter(this.context, android.R.layout.simple_list_item_1, reshte);
        ArrayAdapter adapterMaghta = new ArrayAdapter(this.context, android.R.layout.simple_list_item_1, maghta);
        acReshte.setAdapter(adapterReshte);
        acReshte.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    boolean errState = true;
                    for (String s : reshte) {
                        if (s.indexOf(acReshte.getText().toString().trim()) >= 0) {
                            errState = false;
                            break;
                        }
                    }
                    if (errState) {
                        acReshte.setError("نام رشته اشتباه وارد شده است");
                    } else {
                        acReshte.setError(null);
                    }
                } else
                    acReshte.showDropDown();
            }
        });
        acReshte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acReshte.showDropDown();
            }
        });

        acMaghta.setAdapter(adapterMaghta);
        acMaghta.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    boolean errState = true;
                    for (String s : maghta) {
                        if (s.indexOf(acMaghta.getText().toString().trim()) >= 0) {
                            errState = false;
                            break;
                        }
                    }
                    if (errState) {
                        acMaghta.setError("مقطع اشتباه وارد شده است");
                    } else {
                        acMaghta.setError(null);
                    }
                } else
                    acMaghta.showDropDown();
            }
        });
        acMaghta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acMaghta.showDropDown();
            }
        });
    }

    private class CallSoapSend extends AsyncTask<String, Void, String> {

        ProgressBar progressBar;
        String phone_id = "";
        Student student;

        private CallSoapSend(Student student) {
            this.student = student;
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
            pi.setValue(student.get_iddaneshjo());
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_namdaneshjo");
            pi.setValue(student.get_namdaneshjo());
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_daneshjodaneshgah");
            pi.setValue(student.get_daneshjodaneshgah().split("-")[0]);
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_daneshjomaqtae");
            pi.setValue(student.get_daneshjomaqtae().split("-")[0]);
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_daneshjoreshte");
            pi.setValue(student.get_daneshjoreshte().split("-")[0]);
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            pi = new PropertyInfo();
            pi.setName("_daneshjopassword");
            pi.setValue("1");//student.get_daneshjopassword()
            pi.setType(String.class);
            parametrs.parametrs.add(pi);

            parametrs.OPERATION_NAME = OperationList.InsertDaneshjoo;
            return new CallSoap(parametrs).Call();
        }

        @Override
        protected void onPostExecute(String result) {
            Log.i(TAG, "result = " + result);
            if (result.contains("InsertOk")) {
                Toasty.success(context, "ثبت نام با موفقیت انجام شد").show();
                Toasty.success(context, "کلمه عبور پیش فرض برای شما 1 می باشد").show();
                getActivity().startActivity(new Intent(context, MainActivity.class));
            } else {
                Toasty.error(context, "متاسفانه ثبت نام  انجام نشده است").show();
                Log.i(TAG, "result = " + result);
            }
            this.progressBar.setVisibility(View.GONE);
        }
    }
}
