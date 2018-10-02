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
import nihad.uninews.ir.uninews.Adapters.PortAdapter2;
import nihad.uninews.ir.uninews.Models.ItemPort2;
import nihad.uninews.ir.uninews.Models.Reshte;
import nihad.uninews.ir.uninews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabItem3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View z= inflater.inflate(R.layout.fragment_tab_item3,container,false);
        Realm myRealm = Realm.getInstance(getContext());
        myRealm.beginTransaction();
        List<Reshte> reshtes = myRealm.where(Reshte.class).findAll();
        myRealm.commitTransaction();
        RecyclerView rec5 = z.findViewById(R.id.TabList3);
        rec5.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rec5.setAdapter(new PortAdapter2(getContext(), reshtes));
        return z;
    }

//    private ArrayList<ItemPort2> initDataset4(){
//        ArrayList<ItemPort2> items = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            ItemPort2 item5 = new ItemPort2("کامپیوتر", "دوره کاردانی");
//            items.add(item5);
//        }
//        return items;
//    }

}
