package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FrameTest extends AppCompatActivity {
    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    EditText userinfo1;
    EditText userinfo2;
    EditText userinfo3;
    TextView signupinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_layout_test);
        linear1 = findViewById(R.id.loginpage);
        linear2 = findViewById(R.id.signuppage);
        linear3 = findViewById(R.id.finalpage);
        signupinfo = findViewById(R.id.signupinfo);
        userinfo1 = findViewById(R.id.userid);
        userinfo2 = findViewById(R.id.username);
        userinfo3 = findViewById(R.id.userpwd);
    }

    //Button이 클릭될때 호출되는 메소드 = View.onClickListener의
    //public void onClick(View v)메소드와 동일한 역활
    public void myClick(View v) {
        if (v.getId()==R.id.btnlogin){
            linear1.setVisibility(View.VISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btnsignup) {
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.VISIBLE);
            linear3.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btncontent){
            linear1.setVisibility(View.INVISIBLE);
            linear2.setVisibility(View.INVISIBLE);
            linear3.setVisibility(View.VISIBLE);
        }
        /*else if(v.getId()==R.id.starsignup){
            userinfo1.append(signupinfo.getText()+"\n");
            userinfo2.append(signupinfo.getText()+"\n");
            userinfo3.append(signupinfo.getText()+"\n");

        }*/
    }
}
