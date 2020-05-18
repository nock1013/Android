package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;


public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1 ;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3 ;
    ViewPager fragment_viewPager;
    TabLayout tabLayout;
    String[] tab_txt = {"추천여행지","축제","나의여행지"};
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        tabLayout = findViewById(R.id.examtab);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();

        fragmentArrayList.add(viewFragment1);
        fragmentArrayList.add(viewFragment2);
        fragmentArrayList.add(viewFragment3);
        //tabLayout.setTabGravity(Gravity.LEFT);

        FragAdapter adapter =
                new FragAdapter(getSupportFragmentManager(),
                                            fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
        tabLayout.setupWithViewPager(fragment_viewPager);
    }
    public void btn_click(View view){
       fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }

    class FragAdapter extends FragmentStatePagerAdapter {

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_txt[position];
        }
    }

    class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(FragmentExam01.this,"페이지가 전환",
                    Toast.LENGTH_LONG).show();
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
