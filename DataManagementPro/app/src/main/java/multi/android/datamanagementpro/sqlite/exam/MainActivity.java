package multi.android.datamanagementpro.sqlite.exam;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import multi.android.datamanagementpro.R;


public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);


		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);


		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);

	}

	@Override
	public void onClick(View v) {
		handler = new DBHandler(this);
		if(v.getId()== R.id.btnIns){
			/*if(edtName!=null& edtSu!=null &edtPrice!=null) {*/
				handler.insert(
						edtName.getText().toString(),
						edtPrice.getText().toString(),
						edtSu.getText().toString());
				printToast("정보입력완료");
			/*}*/
		}else if(v.getId()==R.id.btnResult){
			Cursor cursor = handler.selectAll();
			ArrayList<ProductItem> arrayList = new ArrayList<ProductItem>();
			while (cursor.moveToNext()) {
				String id = cursor.getString(0);
				String name = cursor.getString(1);
				/*String price = cursor.getString(2);*/
				String totPrice = cursor.getString(4);
				arrayList.add(new ProductItem(id,name,totPrice));
			}
			ArrayAdapter<ProductItem> adapter = new ArrayAdapter<ProductItem>(MainActivity.this,
					android.R.layout.simple_list_item_1,
					arrayList);
			listview.setAdapter(adapter);


		}else if(v.getId()==R.id.btnResult2){
			Cursor cursor = handler.selectAll();
			ArrayList<HashMap<String,String>> list =
						new ArrayList<HashMap<String,String>>();
				while (cursor.moveToNext()) {
					HashMap item = new HashMap<String, String>();
					item.put("name",cursor.getString(1).toString());
					item.put("price", cursor.getString(2).toString());
					list.add(item);
				}
				SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,
							android.R.layout.simple_list_item_2,
							new String[]{"name","price"},
							new int[]{android.R.id.text1,android.R.id.text2});
				listview.setAdapter(simpleAdapter);

		}else if(v.getId()==R.id.btnSearch){
			Cursor cursor = handler.search(edtName.getText().toString());
			ArrayList<HashMap<String,String>> list =
					new ArrayList<HashMap<String,String>>();
			while (cursor.moveToNext()) {
				HashMap item = new HashMap<String, String>();
				item.put("name",cursor.getString(1));
				item.put("price", cursor.getString(2));
				list.add(item);
			}
			SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,
					android.R.layout.simple_list_item_2,
					new String[]{"name","price"},
					new int[]{android.R.id.text1,android.R.id.text2});
			listview.setAdapter(simpleAdapter);
		}
	}
	public static final int DATA_INTENT = 0;
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		ProductItem item = (ProductItem) parent.getAdapter().getItem(position);
		Intent intent = new Intent(
				MainActivity.this, ReadActivity.class);
		intent.putExtra("name", item);
		startActivity(intent);

	}

	public void printToast(String msg){
		Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
	}
}



















