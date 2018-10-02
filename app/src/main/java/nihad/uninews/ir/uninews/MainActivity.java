package nihad.uninews.ir.uninews;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.ksoap2.serialization.PropertyInfo;

import es.dmoral.toasty.Toasty;
import nihad.uninews.ir.uninews.Fragments.ProfileFragment;
import nihad.uninews.ir.uninews.Fragments.SettingsFragment;
import nihad.uninews.ir.uninews.Fragments.TrendingFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment =null;

            switch (item.getItemId()){
                case R.id.navigation_home:
                    selectedFragment =new TrendingFragment();
                    break;

                case R.id.navigation_dashboard:
                    selectedFragment =new ProfileFragment();
                    break;

                case R.id.navigation_notifications:
                    selectedFragment =new SettingsFragment();
                    break;
            }
            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                    ,selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav =findViewById(R.id.navigation);

        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new TrendingFragment()).commit();
    }

}
