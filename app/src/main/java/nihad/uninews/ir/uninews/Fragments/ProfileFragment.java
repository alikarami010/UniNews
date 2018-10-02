package nihad.uninews.ir.uninews.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import nihad.uninews.ir.uninews.Adapters.UnitAdapter;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.Models.Item3;
import nihad.uninews.ir.uninews.R;
import nihad.uninews.ir.uninews.ViewPageActivity;


public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile,container,false);
        LinearLayout q = v.findViewById(R.id.lnrSemester1);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
                Intent z = new Intent(getContext(),ViewPageActivity.class);
                startActivity(z);
            }
        });

        RecyclerView rec3 = v.findViewById(R.id.UnitListt);
        rec3.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,true));
        rec3.setNestedScrollingEnabled(false);
        rec3.setAdapter(new UnitAdapter(getContext(),initDataset4()));

        TextView tvName = v.findViewById(R.id.tvName);
        TextView tvUniName = v.findViewById(R.id.tvUniName);
        TextView tvStudentId = v.findViewById(R.id.tvStudentId);
        tvName.setText(Common.student.get_namdaneshjo());
        tvStudentId.setText(Common.student.get_iddaneshjo()+"");
        tvUniName.setText(Common.student.get_namdaneshgah());
        return  v;
    }

    private ArrayList<Item3> initDataset4(){
        ArrayList<Item3> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Item3 item = new Item3("ریاضی عمومی", "۱ ساعت ۳۰ دقیقه","۰۹:۳۰","۰۸:۰۰","۳۰۵","عبدالله ناصری","۲۳۴۲");
            items.add(item);
        }
        return items;
    }
}