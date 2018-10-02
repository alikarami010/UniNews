package nihad.uninews.ir.uninews.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import nihad.uninews.ir.uninews.Models.BasicInfo;
import nihad.uninews.ir.uninews.Models.NotificationSettings;
import nihad.uninews.ir.uninews.R;

public class SettingsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View c = inflater.inflate(R.layout.fragment_settings, container, false);
        LinearLayout q = c.findViewById(R.id.profile_id);
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                // Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
                Intent z = new Intent(getContext(), BasicInfo.class);
                startActivity(z);
            }
        });
        LinearLayout d = c.findViewById(R.id.Noti);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {
                // Toast.makeText(getContext(),"",Toast.LENGTH_LONG).show();
                Intent z = new Intent(getContext(), NotificationSettings.class);
                startActivity(z);
            }
        });
        return c;
    }
}