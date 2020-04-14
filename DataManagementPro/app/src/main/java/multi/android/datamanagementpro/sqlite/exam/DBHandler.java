package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;


public class DBHandler {
    private ExamDBHelper helper;
    private SQLiteDatabase db;


    public DBHandler(Context context) {
        this.helper = new ExamDBHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public void insert(String name, String price, String su) {
        int price1 = Integer.parseInt(price);
        int su1 =Integer.parseInt(su);
        int totPrice = price1*su1;
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("price", price);
        contentValues.put("su", su);
        contentValues.put("totPrice",totPrice);
        db.insert("product",null,contentValues);
    }

    public Cursor selectAll() {
        Cursor cursor = db.query("product", null, null,
                null, null, null, null);
        /*ArrayList<productItem> arrayList = new ArrayList<productItem>();*/

        return cursor;
    }

    public Cursor search(String name){
        String  str = "%"+name+"%";
        Cursor cursor = db.query("product",null,"name like ?",
                new String[]{str},null,null,null);
        return cursor;
    }

}
