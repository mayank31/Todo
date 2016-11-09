package com.example.mayankgupta.todo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {
    DataBaseAdapter DataBaseAdapter;
    public static ArrayList<String> titleList = new ArrayList<>();
    public static ArrayList<String> descList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            DataBaseAdapter = new DataBaseAdapter(getApplicationContext());
            DataBaseAdapter = DataBaseAdapter.open();
            Cursor cursor=DataBaseAdapter.getData();

            if(cursor.getCount()<1){

            }
            else {
                int i=cursor.getCount();
                while(i>0) {
                    titleList.add(cursor.getString(0));
                    descList.add(cursor.getString(1));
                    System.out.println("hi1: "+cursor.getString(0));

                    i--;
                    cursor.moveToNext();

                }
                addItem.setTitleList(titleList);
                addItem.setDescList(descList);
            }

            Fragment fragment = new  RecyclerListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.content, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.add) {
            Intent i = new Intent(getApplicationContext(), addItem.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
