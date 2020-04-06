package exam.day03.view.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewTestActivity extends AppCompatActivity {
    //1. ListView에 출력할 데이터
    String[] datalist = {"java","oracle","HTML","CSS","javascript","servlet","jsp","spring",
    "hadoop","flume","sqoop","hive","R","android"};
    ListView listView;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);
        listView = findViewById(R.id.listview1);
        txt = findViewById(R.id.listTxt);
        /*
         리스트뷰에 출력할 데이터?
         어떤 디자인으로 출력? */
        //2. Adepter 객체를 선택햇 생성
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,
                                                datalist);
        //3.ListView에서 어댑터가 작업할 수 있도록 ListView에 어댑터셋팅
        listView.setAdapter(adapter);

        //이벤트연결
        MyListener listener = new MyListener();
        listView.setOnItemClickListener(listener);
    }
    class MyListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            txt.setText(datalist[position]);
        }
    }
}
