package nihad.uninews.ir.uninews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import nihad.uninews.ir.uninews.Models.Item;
import nihad.uninews.ir.uninews.Models.Uni;
import nihad.uninews.ir.uninews.R;

public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {


    private Context context;
    private List<Uni> items;

    public UniversityAdapter(Context context, List<Uni> items){
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Glide.with(context)
                .load(items.get(position).getGImg())
                .into(viewHolder.img);
        viewHolder.txtDesc.setText(items.get(position).getGImgDesc());
        viewHolder.txtTtile.setText(items.get(position).getGNamDaneshgah());
        if (position==0){
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) viewHolder.view.getLayoutParams();
            p.setMargins(15,0,45,0);
            viewHolder.view.requestLayout();

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends  RecyclerView.ViewHolder{

        View view;
        TextView txtTtile;
        TextView txtDesc;
        ImageView img;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            txtTtile = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            img = itemView.findViewById(R.id.img);

        }
    }


}
