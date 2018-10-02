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

public class Regester extends Fragment {
    public static String TAG = "Regester";
    Context context;
    EditText StudentID;
    EditText MelliCode;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_login2, container, false);
        Button btnNext =  view.findViewById(R.id.btnNext);
        StudentID = view.findViewById(R.id.StudentID);
        MelliCode = view.findViewById(R.id.MelliCode);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsValidData()){
                    frmLogin.student.set_iddaneshjo(StudentID.getText().toString().trim());
//                    frmLogin.student.set_(StudentID.getText().toString().trim());
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                            ,new Regester2()).commit();
                }
            }
        });
        return view;
    }
    private boolean IsValidData()
    {
        boolean state = false;
        if (StudentID.getText().toString().length()<5)
        {
            StudentID.setError("کد وارد شده صحیحی نمی باشد");
            return false;
        }
        else StudentID.setError(null);
        if (MelliCode.getText().toString().length()!=10)
        {
            MelliCode.setError("کد ملی بایستی 10 رقم باشد");
            return false;
        }else MelliCode.setError(null);
        return true;
    }

}
