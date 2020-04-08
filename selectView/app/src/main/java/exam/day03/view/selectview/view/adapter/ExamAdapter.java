package exam.day03.view.selectview.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExamAdapter extends ArrayAdapter<ActorItem> {
    private Context context;
    private int resId;
    private ArrayList<ActorItem> actorlist;

    public ExamAdapter(Context context, int resId, ArrayList<ActorItem> actorlist) {
        super(context, resId, actorlist);
        this.context = context;
        this.resId = resId;
        this.actorlist = actorlist;
    }

    HashMap<Integer,SaveExamState> saveData = new HashMap<Integer,SaveExamState>();

    @Override
    public int getCount() {
        return actorlist.size();
    }

    @Override
    public ActorItem getItem(int position) {
        return actorlist.get(position);
    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Log.d("getview", "getview:" + position);
        long start = System.nanoTime();
        ViewHolder holder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resId, null);


            //뷰찾아오기
            holder = new ViewHolder(convertView);
            //홀더저장
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ActorItem actorItem = actorlist.get(position);
        if(actorItem!=null) {
            ImageView imageView = holder.exam_imgView;
            TextView nameView = holder.exam_nameView;
            TextView dateView = holder.exam_date;
            TextView checkTextView = holder.exam_checkTxt;
            final CheckBox checkBoxView = holder.exam_checkBox;

            imageView.setImageResource(actorItem.examImg);
            nameView.setText(actorItem.name);
            dateView.setText(actorItem.date);
            checkTextView.setText(actorItem.checkTxt);


            final SaveExamState state = saveData.get(position);
            if (state != null) {
                checkBoxView.setChecked(true);
            } else {
                checkBoxView.setChecked(false);
            }
            checkBoxView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    boolean data = checkBoxView.isChecked();
                    SaveExamState state = new SaveExamState();
                    state.checkbox =data;
                    saveData.put(position,state);

                }
            });
        }
        long end = System.nanoTime();
        Log.d("getview",(end-start)+"");
        return convertView;
    }
}
