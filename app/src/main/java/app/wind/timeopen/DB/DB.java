package app.wind.timeopen.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;



/**
 * Created by Miki on 12/21/2015.
 */
public class DB extends SQLiteOpenHelper {
    private SQLiteDatabase db;
    private static final String DB_NAME = "time";
    private static final int DB_VERSION = 1;

    public static final String TABLE_TIME = "time";
    public static final String TIME_ID = "id";
    public static final String TIME_SHOP = "shop";
    public static final String TIME_OPEN = "open";
    public static final String TIME_CLOSE = "close";




    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_TIME + "( " + TIME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                TIME_SHOP + " TEXT," + TIME_OPEN + " INTEGER," + TIME_CLOSE + " INTEGER );");

        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน A', 600, 1020);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน B', 720, 1440);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน C', 1020, 60);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน D', 480, 1200);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน E', 1140, 1020);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน F', 0, 1441);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน G', 0, 1437);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน H', 300, 240);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน I', 240, 300);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน J', 480, 1080);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน K', 300, 840);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน L', 360, 720);");
        db.execSQL("INSERT INTO " + TABLE_TIME + " (" + TIME_SHOP + ", " + TIME_OPEN
                + ", " + TIME_CLOSE + ") VALUES ('ร้าน M', 0, 1441);");
        Log.e("check","create DB");




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public void openDB()
    {
        db = this.getWritableDatabase();
    }

    public String[] getShop(int time){

        String shopOpen[] = null;
        ArrayList<String> shopQuery=new ArrayList<String>();
        openDB();
        String strSQL  = "SELECT * FROM " + TABLE_TIME;
        Cursor cursor = db.rawQuery(strSQL, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {


                int i = 0;
                do {
                    if(cursor.getInt(2)>cursor.getInt(3)){
                        if(time >= cursor.getInt(2) || time < cursor.getInt(3)) {
                            shopQuery.add( cursor.getString(1));


                        }
                    }else {
                        if (time >= cursor.getInt(2) && time < cursor.getInt(3)) {
                            shopQuery.add( cursor.getString(1));


                        }
                    }

                    i++;
                } while (cursor.moveToNext());
            }
        }
        shopOpen = new String[shopQuery.size()];
        for (int i=0;i<shopQuery.size();i++){
            if(shopQuery.size()!=0){
                shopOpen[i]=shopQuery.get(i);

            }
        }
        cursor.close();
        db.close();
        return shopOpen;
    }
}
