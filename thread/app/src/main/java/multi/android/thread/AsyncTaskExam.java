package multi.android.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AsyncTaskExam extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    ImageView imageView;
    Button button;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);


        /*progressBar.incrementProgressBy(1);*/

    }
    public void ck_bt(View view){
        if(view.getId()==R.id.button) {
            AsysncTaskExam asysncTaskExam = new AsysncTaskExam();
            //매개변수를 정의하면 매개변수가 doInBackground를 호출할때 전달
            asysncTaskExam.execute();
        }
    }

    //AsyncTask클래스를 상속하여 작업할 클래스를 정의
    //Void 타입을 설정 안함
    class AsysncTaskExam extends AsyncTask<Integer,Integer,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(50);
        }
        @Override
        protected Integer doInBackground(Integer... integers) {
            int total=0;
            for(int i=1;i<=50;i++){
                total = total+i;
                SystemClock.sleep(100);
                publishProgress(i);
            }
            return total;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0]+"");
            progressBar.incrementProgressBy(1);
            //doInBackground에서 발생하는 값을 이용해서 화면을 변경하고 싶은 경우
            if(values[0]%2==0){
                imageView.setImageResource(R.drawable.d1);
            }else {
                imageView.setImageResource(R.drawable.d2);
            }
        }
        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            textView.setText(integer+"");
        }
    }
}
