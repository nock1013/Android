package multi.android.material_design_pro2.recyler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;

public class CardRecyclerExam extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        recyclerView = findViewById(R.id.img_list);
        List<CardItem> recycler_exam_data = new ArrayList<CardItem>();
        CardItem item1 = new CardItem(R.drawable.lee,"이민호의 신의");
        CardItem item2 = new CardItem(R.drawable.gong,"도깨비 머리떡짐");
        CardItem item3 = new CardItem(R.drawable.jang,"장기용");
        CardItem item4 = new CardItem(R.drawable.jung,"정우성");
        CardItem item5 = new CardItem(R.drawable.so,"소지섭섭섭");

        recycler_exam_data.add(item1);
        recycler_exam_data.add(item2);
        recycler_exam_data.add(item3);
        recycler_exam_data.add(item4);
        recycler_exam_data.add(item5);

        CardAdapter adapter = new CardAdapter(this,
                                                        R.layout.activity_card_view_test,
                                                        recycler_exam_data);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        /*GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);*/
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);// VERTICAL LinearLayout이 셋팅

        recyclerView.setAdapter(adapter);




    }

}
