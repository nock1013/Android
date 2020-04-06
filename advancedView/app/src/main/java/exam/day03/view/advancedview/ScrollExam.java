package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
//이벤트를 발생시킬 소스객체가 있는 액티비티에서 이벤트를 처리하는 작업도
//같이 할 수 있도록 구현
//1. 이벤트에 반응하는(미리 정해져 있다.)클래스를 상속받는다.
//2. 메소드를 오버라이딩한다.
//  ex)버튼을 클릭할때
//     실행될 리스너 = > View.OnClickListener의 onClick메소드가 호출
public class ScrollExam extends AppCompatActivity implements View.OnClickListener{
    ImageView examImg;
    ImageView examImg2;
    int scrollIndex;
    Button btnUp;
    Button btnDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_scroll_view_exam);
        //layout에 디자인한 ImageView와 Button 객체를 받아오기
        examImg = findViewById(R.id.upImage);
        examImg2 = findViewById(R.id.downImage);
        btnUp = findViewById(R.id.btnUp);
        btnDown = findViewById(R.id.btnDown);
        //setOnClickListener라는 메소드를 이용해서 이벤트소스에 이벤트가 발생했을 떄
        //처리할 기능이 구현된 리스너 객체가 어떤 것인지 등록
        //implements View, onClickListener해놔서 this임
        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);
    }
    //onClick메소드를 호출하는 이벤트 소스객체는 다양
    //매개변수에 전달되는 View는 이벤트를 발생기킨 소스객체
    @Override
    public void onClick(View v) {
        Log.d("myevent","이벤트가 발생도었습니다. , 이벤트 처리합니다.");
        if (v.getId()==R.id.btnUp){
            imageUp();
        }else if(v.getId()==R.id.btnDown) {
            imageDown();
        }
    }

        public void imageDown(){
        //ImageView에 이미지리소스를 추가
            examImg.setImageResource(0);//이미지 없애기
            examImg2.setImageResource(R.drawable.beach);
            //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도
            //화면이 갱신이 자동으로 되지 않기 때문에 변경되지 않는다.
            //애니메이션을 적용하는 경우는 바로바로 반영이 되어야 하므로 화면을 갱신해야 한다.
            examImg.invalidate();
            examImg2.invalidate();
        }

        public void imageUp(){
            examImg.setImageResource(R.drawable.beach);
            examImg2.setImageResource(0);//이미지 없애기
            examImg.invalidate();
            examImg2.invalidate();
        }

}


