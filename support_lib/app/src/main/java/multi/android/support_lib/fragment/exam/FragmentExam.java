package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import multi.android.support_lib.R;

public class FragmentExam extends AppCompatActivity {
    ViewFragment1 viewFragment1 = new ViewFragment1();
    ViewFragment2 viewFragment2 = new ViewFragment2();
    ViewFragment3 viewFragment3 = new ViewFragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear02);

    }
    public void btn_click(View view){
        setFragment(view.getTag().toString());
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getTag().toString()){
            case "0":
                fragmentTransaction.replace(R.id.container,viewFragment1);
                break;
            case "1":
                fragmentTransaction.replace(R.id.container,viewFragment2);
                break;
            case "2":
                fragmentTransaction.replace(R.id.container,viewFragment3);
                break;
        }
        fragmentTransaction.commit();*/
    }
     public void setFragment(String idx){
        FragmentManager fragmentManager = getSupportFragmentManager();
        //프레그먼트의 변화를 관리하는 객체
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (idx){
            case "0":
                fragmentTransaction.replace(R.id.container,viewFragment1);
                break;
            case "1":
                fragmentTransaction.replace(R.id.container,viewFragment2);
                break;
            case "2":
                fragmentTransaction.replace(R.id.container,viewFragment3);
                break;
        }
        fragmentTransaction.commit();

    }

}
