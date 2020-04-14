package multi.android.support_lib.viewpager.exam2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.support_lib.R;

public class ExamFirstActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    EditText name;
    EditText telNum;
    TextView result;
    public static final int DATA_INTENT = 0;
    public static final int OBJECT_INTENT = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        btn = findViewById(R.id.Button01);
        btn2 = findViewById(R.id.Button02);
        name = findViewById(R.id.EditText01);
        telNum = findViewById(R.id.EditText02);
        result = findViewById(R.id.first_return);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //명시적인텐트
                Intent intent = new Intent(
                        ExamFirstActivity.this, ExamSecondActivity.class);
                /*intent.putExtra("id_info","입력한 id:"+name+", 입력한 pass:"+telNum);*/
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("telNum",telNum.getText().toString());

                startActivityForResult(intent,DATA_INTENT);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //액티비티를 호출하면서 인텐트에 객체를 공유
                Intent intent = new Intent(
                        ExamFirstActivity.this, ExamSecondActivity.class);
                User dto = new User(name.getText().toString(),
                                    telNum.getText().toString());
                intent.putExtra("dto",dto);
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        //requestCode,resultCode 항상작업
        if(requestCode==DATA_INTENT){
            if(resultCode==RESULT_OK){
                boolean state = intent.getBooleanExtra("chkVal",false);
                if(state){
                    result.setText("우수회원설정");
                }else {
                    result.setText("일반회원설정");
                }
            }
        }
    }
}
