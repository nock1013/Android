package multi.android.material_design_pro2.drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import multi.android.material_design_pro2.R;

public class DrawerTest extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.main_drawer);
        //액션바에 추가될 버튼 설정 - 버튼을 선택하면 NavigationView가 display
        //                         버튼을 다시 선택하면 NavigationView가 화면에서 사라지도록 설정
        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                                            R.string.open_str,
                                            R.string.close_str);//res->values->strings.xml등록
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.main_drawer_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id == R.id.item1){
                    Toast.makeText(DrawerTest.this, "내가 본 레시피", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.item2){
                    Toast.makeText(DrawerTest.this, "스크랩한 레시피", Toast.LENGTH_SHORT).show();
                }else if (id == R.id.item3){
                    Toast.makeText(DrawerTest.this, "리뷰한 레시피", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DrawerTest.this, "레시피노트", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
    //onOptionsItemSelected메소드 구현해 줘야 사용할 수 있다.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "onOptionsItemSelected", Toast.LENGTH_SHORT).show();
        if(toggle.onOptionsItemSelected(item)){
            Toast.makeText(this, "if", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
