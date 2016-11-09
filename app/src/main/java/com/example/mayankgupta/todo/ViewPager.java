package com.example.mayankgupta.todo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewPager extends AppCompatActivity {

    int position;
    ArrayList titlelist=new ArrayList();
    ArrayList desclist=new ArrayList();
todoPager tdpager=null;
    private android.support.v4.view.ViewPager viewpager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        Intent i=getIntent();
        position=i.getIntExtra("Position",position);
      viewpager = (android.support.v4.view.ViewPager) findViewById (R.id.view_pager);
        titlelist= addItem.getTitleList();
        desclist=addItem.getDescList();
        tdpager = new todoPager(getSupportFragmentManager(),titlelist,desclist,position);
        viewpager.setAdapter(tdpager);
        viewpager.setCurrentItem(position);

    }
}
