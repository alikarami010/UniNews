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
import nihad.uninews.ir.uninews.Adapters.PortAdapter1;
import nihad.uninews.ir.uninews.Models.ItemPort1;
import nihad.uninews.ir.uninews.Models.Maghta;
import nihad.uninews.ir.uninews.R;


public class TabItem2 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View z= inflater.inflate(R.layout.fragment_tab_item2,container,false);
        Realm myRealm = Realm.getInstance(getContext());
        myRealm.beginTransaction();
        List<Maghta> maghtas = myRealm.where(Maghta.class).findAll();
        myRealm.commitTransaction();
        RecyclerView rec5 = z.findViewById(R.id.TabList2);
        rec5.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec5.setAdapter(new PortAdapter1(getContext(), maghtas));
        return z;
    }

//    private ArrayList<ItemPort1> initDataset4(){
//        ArrayList<ItemPort1> items = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            ItemPort1 item5 = new ItemPort1("کاردانی", "اول سال تحصیلی ۹۷");
//            items.add(item5);
//        }
//        return items;
//    }
}
