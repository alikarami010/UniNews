package nihad.uninews.ir.uninews.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import io.realm.Realm;
import nihad.uninews.ir.uninews.Adapters.LessonsAdapter;
import nihad.uninews.ir.uninews.Adapters.NewsAdapter;
import nihad.uninews.ir.uninews.Adapters.UniversityAdapter;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.Models.Dars;
import nihad.uninews.ir.uninews.Models.Item;
import nihad.uninews.ir.uninews.Models.Item1;
import nihad.uninews.ir.uninews.Models.Item2;
import nihad.uninews.ir.uninews.Models.News;
import nihad.uninews.ir.uninews.Models.Student;
import nihad.uninews.ir.uninews.Models.Uni;
import nihad.uninews.ir.uninews.R;
import nihad.uninews.ir.uninews.WebServices.CallSoap;
import nihad.uninews.ir.uninews.WebServices.CallSoapParametrs;
import nihad.uninews.ir.uninews.WebServices.OperationList;

public class TrendingFragment extends Fragment {
    Context context;
    Activity activity;
    public static String TAG = "TrendingFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_trending, container, false);

        context = getContext();
        activity = getActivity();
        RecyclerView rec = v.findViewById(R.id.recItems);
        rec.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
        rec.setAdapter(new UniversityAdapter(getContext(), getUni()));


        RecyclerView rec1 = v.findViewById(R.id.recClass);
        rec1.setLayoutManager(new GridLayoutManager(getContext(), 2, LinearLayoutManager.HORIZONTAL, true));
        rec1.setAdapter(new LessonsAdapter(getContext(), getDars()));


        RecyclerView rec2 = v.findViewById(R.id.newnews);
        rec2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
        rec2.setNestedScrollingEnabled(false);
        rec2.setAdapter(new NewsAdapter(getContext(), getNews()));

        return v;
    }


    private List<Uni> getUni() {
        Realm myRealm = Realm.getInstance(context);
        myRealm.beginTransaction();
        List<Uni> unis = myRealm.where(Uni.class).findAll();
        myRealm.commitTransaction();
        return unis;
    }


    private List<Dars> getDars() {
        Realm myRealm = Realm.getInstance(context);
        myRealm.beginTransaction();
        List<Dars> dars = myRealm.where(Dars.class).findAll();
        myRealm.commitTransaction();
        myRealm.close();
        return dars;
    }


    private  List<News> getNews() {
        Realm myRealm = Realm.getInstance(context);
        myRealm.beginTransaction();
        List<News> news = myRealm.where(News.class).findAll();
        myRealm.commitTransaction();
        myRealm.close();
        return news;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}