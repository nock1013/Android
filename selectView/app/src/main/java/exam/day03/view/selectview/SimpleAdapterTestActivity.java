package exam.day03.view.selectview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends ListActivity {
    //ListActivity상속받는다.
    //두 줄 택스트로 리스트뷰 구성하기

    ArrayList<HashMap<String,String>> listdata = new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //리스트 구성할 샘플 데이터 준비
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("name","오성식");
        item.put("telNum","010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","홍길동");
        item.put("telNum","010-1121-2522");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","김범룡");
        item.put("telNum","010-1331-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","이민호");
        item.put("telNum","010-1111-5552");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","지드래곤");
        item.put("telNum","010-3333-6622");
        listdata.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,
                                    listdata,//HashMap으로 구성된 데이터가 저장된 리스트
                                    android.R.layout.simple_list_item_2,//row의 디자인
                                    new String[]{"name","telNum"},//HashMap에 저장된 키 리스트
                                    new int[]{android.R.id.text1,android.R.id.text2}
                                    //위에서 정의한 맵 데이터를 어떤 view에 출력할 것인지
                                    //키의 순서와 동일한 리소스아이디 순서
                                    );
        setListAdapter(adapter);
    }
}
