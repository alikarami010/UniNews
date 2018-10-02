package nihad.uninews.ir.uninews.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import nihad.uninews.ir.uninews.Fragments.TabItem1;
import nihad.uninews.ir.uninews.Fragments.TabItem2;
import nihad.uninews.ir.uninews.Fragments.TabItem3;
import nihad.uninews.ir.uninews.Fragments.TabItem4;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new TabItem1();
            case 1:
                return new TabItem2();
            case 2:
                return new TabItem3();
            case 3:
                return new TabItem4();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
