package com.example.mayankgupta.todo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class todoPager extends FragmentPagerAdapter {

ArrayList<String> mtitle;
    ArrayList<String> mdesc;

    int pos;

    public todoPager(FragmentManager fm, ArrayList<String> title, ArrayList<String> desc, int pos) {
        super(fm);
        this.mtitle=title;
        this.mdesc=desc;

        this.pos=pos;
    }

    @Override
    public Fragment getItem(int position) {
        return new Pager(mtitle.get(position),mdesc.get(position));
    }

    @Override
    public int getCount() {
        return mtitle.size();
    }
}
