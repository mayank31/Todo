package com.example.mayankgupta.todo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Pager extends Fragment {   public TextView mtitle,mdesc;
    String title,desc;
    public Pager(){}
    public Pager(String Title,String description)
    {
        this.title=Title;
        this.desc=description;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView=inflater.inflate(R.layout.fragment_pager,container,false);
        mtitle=(TextView)rootView.findViewById(R.id.pagerText);
        mtitle.setText(title);
        mdesc=(TextView)rootView.findViewById(R.id.pagerDesc);
        mdesc.setText(desc);

        return rootView;
    }
}
