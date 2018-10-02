package nihad.uninews.ir.uninews;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration.Builder;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {
    public static final String TAG = App.class.getSimpleName();
    private static App mInstance;
    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context = getApplicationContext();
        mInstance = this;
        CreateDB();
        SetFont();
    }

    void CreateDB() {
//        Realm.setDefaultConfiguration(new RealmConfiguration.Builder((Context) this).name("default.realm").schemaVersion(3).migration(new RealmMigrations()).build());
//        Realm.setDefaultConfiguration(configuration);
//        Realm.getInstance(configuration);
        Realm.setDefaultConfiguration(new Builder((Context) this).name("default.realm").schemaVersion(0).deleteRealmIfMigrationNeeded().build());
    }

    void SetFont() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/byekan.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
       // CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/khandevane.ttf").setFontAttrId(R.attr.fontPath).build());
    }
    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }
}
