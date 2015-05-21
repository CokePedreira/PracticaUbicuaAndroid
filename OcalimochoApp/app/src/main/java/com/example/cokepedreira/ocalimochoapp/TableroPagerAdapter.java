package com.example.cokepedreira.ocalimochoapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import java.util.List;

/**
 * Created by cokepedreira on 21/5/15.
 */
public class TableroPagerAdapter extends FragmentStatePagerAdapter {

    private List<Casilla> casillas;

    public TableroPagerAdapter (FragmentManager fm, List<Casilla> casillas) {
        super(fm);
        this.casillas = casillas;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentCasilla.newInstance(casillas.get(position));
    }

    @Override
    public int getCount() {
        return casillas.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

}
