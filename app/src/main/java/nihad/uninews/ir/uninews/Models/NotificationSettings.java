package nihad.uninews.ir.uninews.Models;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nihad.uninews.ir.uninews.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class NotificationSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_settings);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
