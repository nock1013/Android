package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import multi.android.material_design_pro.R;


public class FragmentExam extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ListFragment viewFragment2;
    ViewFragment3 viewFragment3;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    ViewPager examPager;
    String[] tab_txt = {"추천여행지","축제","나의여행지"};

    TabLayout tabLayout;
    ArrayList<String> tabdatalist = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        examPager = findViewById(R.id.examPager);
        tabLayout = findViewById(R.id.exam_tab);

        fragmentList.add(viewFragment1);
        fragmentList.add(viewFragment2);
        fragmentList.add(viewFragment3);

        FragAdapter fragmentPagerAdapter = new FragAdapter(getSupportFragmentManager(),
                fragmentList.size());
        examPager.setAdapter(fragmentPagerAdapter);
        /*tabLayout.setupWithViewPager(examPager);*/
        tabLayout.setupWithViewPager(examPager);

    }

    class FragAdapter extends FragmentStatePagerAdapter{

        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tab_txt[position];
            /*tabdatalist.get(position);*/
        }
    }

}
