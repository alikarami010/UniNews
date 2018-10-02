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
import nihad.uninews.ir.uninews.Adapters.PortAdapter;
import nihad.uninews.ir.uninews.Models.ItemPort;
import nihad.uninews.ir.uninews.Models.Term;
import nihad.uninews.ir.uninews.R;


public class TabItem1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View z= inflater.inflate(R.layout.fragment_tab_item1,container,false);
        Realm myRealm = Realm.getInstance(getContext());
        myRealm.beginTransaction();
        List<Term> terms = myRealm.where(Term.class).findAll();
        myRealm.commitTransaction();
        RecyclerView rec5 = z.findViewById(R.id.TabList);
        rec5.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec5.setAdapter(new PortAdapter(getContext(), terms));
        return z;
    }

//    private ArrayList<ItemPort> initDataset4(){
//        ArrayList<ItemPort> items = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            ItemPort item5 = new ItemPort("۹۷۱", "اول سال تحصیلی ۹۷");
//            items.add(item5);
//        }
//        return items;
//    }
}
