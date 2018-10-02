package nihad.uninews.ir.uninews;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.serialization.PropertyInfo;

import io.realm.Realm;
import nihad.uninews.ir.uninews.CommonClasses.Common;
import nihad.uninews.ir.uninews.Fragments.Login;
import nihad.uninews.ir.uninews.Models.Dars;
import nihad.uninews.ir.uninews.Models.Maghta;
import nihad.uninews.ir.uninews.Models.News;
import nihad.uninews.ir.uninews.Models.Reshte;
import nihad.uninews.ir.uninews.Models.Student;
import nihad.uninews.ir.uninews.Models.Term;
import nihad.uninews.ir.uninews.Models.Uni;
import nihad.uninews.ir.uninews.WebServices.CallSoap;
import nihad.uninews.ir.uninews.WebServices.CallSoapParametrs;
import nihad.uninews.ir.uninews.WebServices.OperationList;

/**
 * Created by ali on 18/08/2018.
 */

public class frmLogin extends AppCompatActivity {
    public static Student student;
    Context context;
    Activity activity;
    public static String TAG = "frmLogin";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
        student = new Student();
        setContentView(R.layout.activity_frmlogin);
        new CallSoapAsync().execute();
    }

    private class CallSoapAsync extends AsyncTask<String, Void, String> {
        String phone_id;
        ProgressBar progressBar;


        private CallSoapAsync() {

            this.phone_id = "";
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressBar = new ProgressBar(context);
            this.progressBar.setVisibility(View.VISIBLE);
            this.phone_id = Common.GetIMEI(activity);
        }

        @Override
        protected String doInBackground(String... urls) {
//            progressBar.animate();
            Log.i(TAG, "doInBackground");
            CallSoapParametrs parametrs = new CallSoapParametrs();
            PropertyInfo pi = new PropertyInfo();

            pi.setName("_imei");
            pi.setValue(this.phone_id);
            pi.setType(String.class);
            parametrs.parametrs.add(pi);
            pi = new PropertyInfo();

            pi.setName("_iddaneshjo");
            pi.setValue("1");
            pi.setType(String.class);
            parametrs.parametrs.add(pi);
            pi = new PropertyInfo();

            parametrs.OPERATION_NAME = OperationList.SelectKolDaneshgah;
            String daneshgah = new CallSoap(parametrs).Call();

            parametrs.OPERATION_NAME = OperationList.SelectMaqtae;
            String maghta = new CallSoap(parametrs).Call();

            parametrs.OPERATION_NAME = OperationList.SelectZtblReshte;
            String reshte = new CallSoap(parametrs).Call();

            parametrs.OPERATION_NAME = OperationList.SelectKolDars;
            String dars = new CallSoap(parametrs).Call();

            parametrs.OPERATION_NAME = OperationList.SelectTerm;
            String term = new CallSoap(parametrs).Call();

            parametrs.OPERATION_NAME = OperationList.SelectPublicNews;
            String news = new CallSoap(parametrs).Call();

            Realm myRealm = Realm.getInstance(context);
            try {
                JSONArray DaneshgahArray = new JSONObject(daneshgah).getJSONArray("ZTblDaneshgah");
                JSONArray MaghtaArray = new JSONObject(maghta).getJSONArray("ZTblMaqtae");
                JSONArray ReshteArray = new JSONObject(reshte).getJSONArray("ZTblReshte");
                JSONArray DarsArray = new JSONObject(dars).getJSONArray("ZTblKolDars");
                JSONArray NewsArray = new JSONObject(news).getJSONArray("ZtblPublicNews");
                JSONArray TermArray = new JSONObject(term).getJSONArray("ZTblTerm");

                myRealm.beginTransaction();

                myRealm.clear(Uni.class);
                myRealm.clear(Maghta.class);
                myRealm.clear(Reshte.class);
                myRealm.clear(Dars.class);
                myRealm.clear(News.class);
                myRealm.clear(Term.class);

                myRealm.createAllFromJson(Uni.class, DaneshgahArray);
                myRealm.createAllFromJson(Maghta.class, MaghtaArray);
                myRealm.createAllFromJson(Reshte.class, ReshteArray);
                myRealm.createAllFromJson(Dars.class, DarsArray);
                myRealm.createAllFromJson(News.class, NewsArray);
                myRealm.createAllFromJson(Term.class, TermArray);

                myRealm.commitTransaction();
                myRealm.close();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Log.i(TAG, "doInBackground finish");
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            this.progressBar.setVisibility(View.GONE);
            Common.LoadAppSetting(context);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Login()).commit();
        }
    }

}
