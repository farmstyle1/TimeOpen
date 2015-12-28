package app.wind.timeopen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import app.wind.timeopen.DB.DB;


public class ListViewActivity extends Activity {

    private DB dbHelper;
    private ListView listView;
    private int timeMinute;
    private String[] listViewShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            timeMinute = bundle.getInt("timeMinute");

        }
        dbHelper = new DB(this);
        dbHelper.openDB();
        listViewShop = dbHelper.getShop(timeMinute);







        listView = (ListView)findViewById(R.id.list);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, listViewShop);

            listView.setAdapter(adapter);



    }


}
