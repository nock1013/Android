package multi.android.material_design_pro2.recyler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import multi.android.material_design_pro2.R;

public class RecyclerCircleAdapter extends RecyclerView.Adapter<RecyclerCircleAdapter.examViewHolder> {
    Context context;
    int row_res_id;
    List<CicleItem> data;

    public RecyclerCircleAdapter(Context context, int row_res_id, List<CicleItem> data) {
        this.context = context;
        this.row_res_id = row_res_id;
        this.data = data;
    }

    @NonNull
    @Override
    public examViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(row_res_id,null);
        return new examViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull examViewHolder holder, int position) {
        CircleImageView row_imageView = holder.circleImageView;
            row_imageView.setImageResource(data.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class examViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        public examViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circle_img_view1);
        }
    }

}
