package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import multi.android.support_lib.R;

public class FragmentExam extends AppCompatActivity {
    ViewFragment1 viewFragment1 = new ViewFragment1();
    ViewFragment2 viewFragment2 = new ViewFragment2();
    ViewFragment3 viewFragment3 = new ViewFragment3();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_main);

    }
    public void btn_click(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
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
        fragmentTransaction.commit();
    }

}
