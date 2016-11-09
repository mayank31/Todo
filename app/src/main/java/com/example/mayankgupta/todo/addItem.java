package com.example.mayankgupta.todo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class addItem extends AppCompatActivity {
    EditText mtitle,mdesc;
    Button add;

    String title,description;
    DataBaseAdapter DataBaseAdapter;
    public static ArrayList<String> titleList = new ArrayList<>();
    public static ArrayList<String> descList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        mtitle=(EditText)findViewById(R.id.itemtitle);
        mdesc=(EditText)findViewById(R.id.itemdesc);
        add=(Button)findViewById(R.id.addbutton);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title=mtitle.getText().toString();
                description=mdesc.getText().toString();
                if(title.equals("")||description.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Invalide values",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {

                    ArrayList<String> mtitleList = new ArrayList<>();
                    ArrayList<String> mdescList = new ArrayList<>();
                    mtitleList=getTitleList();
                    mdescList=getDescList();
                   mtitleList.add(title);
                    mdescList.add(description);
                    DataBaseAdapter = new DataBaseAdapter(getApplicationContext());
                    DataBaseAdapter = DataBaseAdapter.open();
                    DataBaseAdapter.insertEntry(title, description);
                    setTitleList(mtitleList);
                    setDescList(mdescList);
                    System.out.println(mtitleList);

finish();
                }



            }
        });
    }
    public static ArrayList<String>  getTitleList()
    {
        return titleList;
    }
    public static void setTitleList(ArrayList<String> titles)
    {
        titleList=titles;
    }
    public static ArrayList<String>  getDescList()
    {
        return descList;
    }
    public static void setDescList(ArrayList<String> titles)
    {
        descList=titles;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        final MenuItem item1 = item;
        //noinspection SimplifiableIfStatement

        if (id == R.id.back) {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }
}
