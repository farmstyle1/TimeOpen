package app.wind.timeopen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import app.wind.timeopen.DB.DB;

public class MainActivity extends Activity {

    private TimePicker timePicker1;
    private TextView time;
    private Calendar calendar;
    private DB dbHelper;
    private int timeMinute;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DB(this);
        dbHelper.openDB();


        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);
        calendar = Calendar.getInstance();


    }

    public void setTime(View view) {
        int hour = timePicker1.getCurrentHour();
        int min = timePicker1.getCurrentMinute();
        timeMinute=(hour*60)+min;

        Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
        intent.putExtra("timeMinute",timeMinute);
        startActivity(intent);





    }




}
