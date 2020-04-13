package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import multi.android.datamanagementpro.R;

public class Exam_Read_Writer extends AppCompatActivity {
    boolean permission_state;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam__read__writer);
        editText = findViewById(R.id.editTxt);
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED) {
            printToast("권한완료했음");
            permission_state = true;
        }else {
            permission_state = false;
            printToast("권한완료안했음");

            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.WRITE_EXTERNAL_STORAGE
                     ,Manifest.permission.READ_EXTERNAL_STORAGE},5);
        }

    }
    /*public void checkPermissions(String[] permissions){
        ArrayList<String> targetList = new ArrayList<String>();

        for (int i =0; i<permissions.length;i++) {
            String curPermission = permissions[i];
            int permissionCheck = ContextCompat.checkSelfPermission(this, curPermission);
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
                printToast("권한설정완료함");
            } else {
                permission_state = false;
                printToast("권한설정해야함");
                if(ActivityCompat.shouldShowRequestPermissionRationale(this,curPermission)){
                    printToast("권한설정이 필요함");
                }else {
                    targetList.add(curPermission);
                }
            }
        }
    }*/


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10 && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED
                && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                permission_state = true;
                printToast("권한설정이 완료.");
            } else {
                permission_state = false;
                printToast("권한설정이 필요합니다.");
            }
        }
    }

    public void openFile(View v) {
        try {
            File file = Environment.getExternalStorageDirectory();
            File dir = new File(file.getAbsolutePath()+"/mynote");
            BufferedReader br = new BufferedReader
                    (new FileReader(dir+"/20200410_memo.txt"));
            String line = "";
            StringBuffer sb = new StringBuffer();

            for (int i =1;(line=br.readLine())!=null;i++){
                sb.append(line+"\n");
            }
            editText.setText(sb);
            /*String line - br.readLine();
            * while (line!=null){
            *   view.append(line+"\n");
            *   line - br.readLine();*/
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public void saveFile(View v) {
        if (permission_state == true) {
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external.getAbsolutePath();
                /*String pkg = getPackageName();*/
                File dir = new File(dirPath +"/mynote");
                outputAll(dir);
            } else {
                printToast("사용불가능");
            }
        } else {
            printToast("권한설정하세요");
        }
    }

    public void newCreateFile(View v) {
        if (permission_state == true) {
            String state = Environment.getExternalStorageState();
            if (state.equals(Environment.MEDIA_MOUNTED)) {
                printToast("사용가능");
                File external = Environment.getExternalStorageDirectory();
                String dirPath = external.getAbsolutePath();
                File dir = new File(dirPath+"/mynote");
                outputAll(dir);
            } else {
                printToast("사용불가능");
            }
        } else {
            printToast("권한설정하세요");
        }
    }



    public void printToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    public void outputAll(File dir){
        if (!dir.exists()) {
            dir.mkdir();
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter(dir + "/20200410_memo.txt");
            fw.write(editText.getText()+"");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
