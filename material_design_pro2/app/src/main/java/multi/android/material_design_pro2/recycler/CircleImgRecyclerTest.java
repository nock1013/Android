package multi.android.material_design_pro2.recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CircleImgRecyclerTest extends AppCompatActivity {
    RecyclerView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_recycler_test);
        list = findViewById(R.id.list);
        //1. Recycler에 출력할 데이터 준비
        List<CircleItem> recycler_simple_data = new ArrayList<CircleItem>();
        CircleItem[] item = new CircleItem[5];
        item[0] = new CircleItem(R.drawable.gong);
        item[1] = new CircleItem(R.drawable.jang);
        item[2] = new CircleItem(R.drawable.jung);
        item[3] = new CircleItem(R.drawable.lee);
        item[4] = new CircleItem(R.drawable.so);

        for(int i=0;i<5;i++){
            recycler_simple_data.add(item[i]);
        }
        //2. Adapter생성
        CircleAdapter adapter = new CircleAdapter(this,
                                    R.layout.circle_item,
                                    recycler_simple_data);

        //3. Recycler에 레이아웃을 설정
        //   LinearLayout, GridLayout
        //  RecyclerView에 설정할 레이아웃객체 생성
        LinearLayoutManager manager =
                        new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //GridLayout설정
        /*GridLayoutManager manager =
                new GridLayoutManager(getApplicationContext(),2);
        list.setHasFixedSize(true);*/
        list.setLayoutManager(manager); //VERTICAL LinearLayout이 셋팅

        //4. Recycler와 adapter를 연결
        list.setAdapter(adapter);
        //5. 추가적인 요소들을 적용할 수 있다. - 꾸미기, 애니메이션
    }
}








