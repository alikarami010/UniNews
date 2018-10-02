package nihad.uninews.ir.uninews.Models;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nihad.uninews.ir.uninews.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class FieldStudy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_study);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/font.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        RecyclerView rec6 = findViewById(R.id.field_list);
        rec6.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        rec6.setAdapter(new AdapterUniList(getApplicationContext(), initDataset2()));
    }

    private ArrayList<ItemUniList> initDataset2(){
        ArrayList<ItemUniList> items = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ItemUniList item = new ItemUniList("کامپیوتر");
            items.add(item);
        }
        return items;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
