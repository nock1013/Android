package multi.android.material_design_pro2.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class CircleAdapter
        extends RecyclerView.Adapter<CircleAdapter.ViewHolder> {
    Context context;
    int row_res_id; //row를 구성하는 layout
    List<CircleItem> data;//RecyclerView에 출력될 전체 데이터

    public CircleAdapter(Context context, int row_res_id, List<CircleItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                         int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("recycler","onBindViewHolder:"+position);
        CircleImageView img = holder.img;
        img.setImageResource(data.get(position).getImg());
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"데이터연결완료",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    //RecyclerView에 출력할 데이터의 갯수리턴
    @Override
    public int getItemCount() {
        return data.size();
    }
    //
    class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

}
