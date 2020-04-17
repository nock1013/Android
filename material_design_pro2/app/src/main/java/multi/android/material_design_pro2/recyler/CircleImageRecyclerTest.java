package multi.android.material_design_pro2.recyler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        recyclerView = findViewById(R.id.img_list);
        List<CicleItem> recycler_exam_data = new ArrayList<CicleItem>();
        CicleItem item1 = new CicleItem(R.drawable.lee);
        CicleItem item2 = new CicleItem(R.drawable.gong);
        CicleItem item3 = new CicleItem(R.drawable.jang);
        CicleItem item4 = new CicleItem(R.drawable.jung);
        CicleItem item5 = new CicleItem(R.drawable.so);

        recycler_exam_data.add(item1);
        recycler_exam_data.add(item2);
        recycler_exam_data.add(item3);
        recycler_exam_data.add(item4);
        recycler_exam_data.add(item5);

        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this,
                                                                   R.layout.simple_img_item,
                                                                   recycler_exam_data);

        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        /*GridLayoutManager manager = new GridLayoutManager(getApplicationContext(),2);*/
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);// VERTICAL LinearLayout이 셋팅

        recyclerView.setAdapter(adapter);




    }

}
