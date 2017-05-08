

package mymarvel.com.mobile.ui.comic;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.mymarvel.core.data.model.Comic;

import java.util.ArrayList;
import java.util.List;

public class ComicViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Comic> mComicList;

    public ComicViewPagerAdapter(FragmentManager fragmentManager, List<Comic> comicList) {
        super(fragmentManager);
        mComicList = new ArrayList<>();
        if(comicList != null) {
            mComicList.addAll(comicList);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return ComicViewPagerFragment.newInstance(mComicList.get(position));
    }

    @Override
    public int getCount() {
        return mComicList.size();
    }
}