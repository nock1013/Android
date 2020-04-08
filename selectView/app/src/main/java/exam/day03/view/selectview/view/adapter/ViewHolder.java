package exam.day03.view.selectview.view.adapter;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import exam.day03.view.selectview.R;

public class ViewHolder {
    ImageView exam_imgView;
    TextView exam_nameView;
    TextView exam_date;
    TextView exam_checkTxt;
    CheckBox exam_checkBox;

    public ViewHolder(View parentView) {
        this.exam_imgView = parentView.findViewById(R.id.myImg);
        this.exam_nameView = parentView.findViewById(R.id.name);
        this.exam_date = parentView.findViewById(R.id.date);
        this.exam_checkTxt = parentView.findViewById(R.id.resultinfo);
        this.exam_checkBox = parentView.findViewById(R.id.exam_chk);
    }
}
