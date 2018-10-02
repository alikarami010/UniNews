package nihad.uninews.ir.uninews.Fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import nihad.uninews.ir.uninews.Adapters.PortAdapter3;

import nihad.uninews.ir.uninews.Models.Dars;
import nihad.uninews.ir.uninews.Models.ItemPort3;
import nihad.uninews.ir.uninews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabItem4 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View z= inflater.inflate(R.layout.fragment_tab_item4,container,false);
        Realm myRealm = Realm.getInstance(getContext());
        myRealm.beginTransaction();
        List<Dars> dars = myRealm.where(Dars.class).findAll();
        myRealm.commitTransaction();
        RecyclerView rec5 = z.findViewById(R.id.TabList4);
        rec5.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec5.setAdapter(new PortAdapter3(getContext(),dars));
        return z;
    }

    private ArrayList<ItemPort3> initDataset4(){
        ArrayList<ItemPort3> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemPort3 item5 = new ItemPort3("ذخیره و بازیابی", "کاردانی کامپیوتر- ۲۳۴۲");
            items.add(item5);
        }
        return items;
    }

}
