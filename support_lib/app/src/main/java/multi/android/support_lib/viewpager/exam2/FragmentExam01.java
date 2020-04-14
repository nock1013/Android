package multi.android.support_lib.viewpager.exam2;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.ListFragment;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;
import multi.android.support_lib.viewpager.exam.ListTestFragment;
import multi.android.support_lib.viewpager.exam.MapFragment;
import multi.android.support_lib.viewpager.exam.ViewFragment1;
import multi.android.support_lib.viewpager.exam.ViewFragment3;

public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    /*ViewFragment2 viewFragment2;*/
    ListFragment viewFragment2;
    ViewFragment3 viewFragment3;
    /*MapFragment viewFragment4;*/
    TestFragment testFragment;
    ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    ViewPager examPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        /*viewFragment4 = new MapFragment();*/
        testFragment = new TestFragment();
        examPager = findViewById(R.id.examPager);

        fragmentList.add(viewFragment1);
        fragmentList.add(viewFragment2);
        fragmentList.add(viewFragment3);
        /*fragmentList.add(viewFragment4);*/
        fragmentList.add(testFragment);

        /*ExamPagerAdapter fragmentPagerAdapter = new ExamPagerAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        examPager.setAdapter(fragmentPagerAdapter);*/

        FragAdapter fragmentPagerAdapter = new FragAdapter(getSupportFragmentManager(),
                fragmentList.size());
        examPager.setAdapter(fragmentPagerAdapter);
        examPager.addOnPageChangeListener(new PageListener());

        /*FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT*/

    }
    public void btn_click(View view){
        //FragmentList를 버튼과 연결 setCurrentItem
        examPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
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
    }

    /*class ExamPagerAdapter extends FragmentPagerAdapter {
        public ExamPagerAdapter(FragmentManager fm, int behavior) {
            super(fm, behavior);

        }


        @NonNull
        @Override
        public Fragment getItem(int position) {

            return viewlist.get(position);
        }

        @Override
        public int getCount() {
            return viewlist.size();
        }
    }*/
    class PageListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경되었을때
            Toast.makeText(FragmentExam01.this,"페이지가 전환",Toast.LENGTH_LONG).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
