package multi.android.map_location_pro.location;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import multi.android.map_location_pro.R;
//현재 위치정보를 가져와서 맵에 연결해서 출력 - avd, device
public class LocationMapExam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_map_exam);
    }
}
