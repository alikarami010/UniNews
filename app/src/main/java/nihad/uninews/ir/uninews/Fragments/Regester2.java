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

public class Regester2 extends Fragment {
    public static String TAG = "Regester";
    Context context;
    EditText Name;
    AutoCompleteTextView acDaneshgah;
    String[] unis = new String[]{""};
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login3, container, false);
        Button btnNext =  view.findViewById(R.id.btnNext);
        Name = view.findViewById(R.id.Name);
        acDaneshgah = view.findViewById(R.id.Daneshgah);
        ConfigAutoCompeletView();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsValidData()){
                    frmLogin.student.set_namdaneshjo(Name.getText().toString().trim());
                    frmLogin.student.set_daneshjodaneshgah(acDaneshgah.getText().toString().trim());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                            ,new Regester3()).commit();
                }
            }
        });
        return view;
    }
    private boolean IsValidData()
    {
        boolean state = false;
        if (Name.getText().toString().length()<3)
        {
            Name.setError(" نام و نام خانوادگی را صحیح وارد کنید");
            return false;
        } else Name.setError(null);
        if (acDaneshgah.getError()!=null)
        {
            return false;
        }
        return true;
    }
    private void ConfigAutoCompeletView() {
        unis = Common.getUniList(context);
        ArrayAdapter adapterUni = new ArrayAdapter(this.context, android.R.layout.simple_list_item_1, unis);
        acDaneshgah.setAdapter(adapterUni);
        acDaneshgah.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    boolean errState = true;
                    for (String s : unis) {
                        if (s.indexOf(acDaneshgah.getText().toString().trim()) >= 0) {
                            errState = false;
                            break;
                        }
                    }
                    if (errState) {
                        acDaneshgah.setError("نام دانشگاه اشتباه وارد شده است");
                    } else {
                        acDaneshgah.setError(null);
                    }
                } else
                    acDaneshgah.showDropDown();
            }
        });
        acDaneshgah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                acDaneshgah.showDropDown();
            }
        });
    }
}
