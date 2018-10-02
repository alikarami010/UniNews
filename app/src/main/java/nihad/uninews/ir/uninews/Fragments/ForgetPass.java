package nihad.uninews.ir.uninews.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import es.dmoral.toasty.Toasty;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.R;
import nihad.uninews.ir.uninews.frmLogin;

/**
 * Created by ali on 19/08/2018.
 */

public class ForgetPass extends Fragment {
    public static String TAG = "ForgetPass";
    Context context;
    EditText etIMEI;
    EditText etMelliCode;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_forget_password, container, false);
        Button btnRestore =  view.findViewById(R.id.btnRestore);
        etIMEI = view.findViewById(R.id.etIMEI);
        etMelliCode = view.findViewById(R.id.etMelliCode);
        etIMEI.setText(Common.GetIMEI(getActivity()));
        btnRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IsValidData()){
                    Toasty.error(context,"وضعیت مشخص نیست").show();
                }
            }
        });
        return view;
    }
    private boolean IsValidData()
    {
        if (etIMEI.getText().toString().length()<13)
        {
            etIMEI.setError("کد IMEI  صحیح نمی باشد");
            return false;
        }
        else etIMEI.setError(null);

        if (etMelliCode.getText().toString().length()!=10)
        {
            etMelliCode.setError("کد ملی صحیح نمی باشد");
            return false;
        }
        else etMelliCode.setError(null);
        return true;
    }

}
