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

import nihad.uninews.ir.uninews.Models.Item2;
import nihad.uninews.ir.uninews.Models.News;
import nihad.uninews.ir.uninews.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context context;
    private List<News> items;

    public NewsAdapter(Context context, List<News> items){
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Glide.with(context)
                .load(items.get(position).getNImg())
                .into(viewHolder.ImgNew);
        viewHolder.DisNew.setText(items.get(position).getNDesc());
        viewHolder.tetleNew.setText(items.get(position).getNBrife());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView tetleNew;
        TextView DisNew;
        ImageView ImgNew;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tetleNew = itemView.findViewById(R.id.tetleNew);
            DisNew = itemView.findViewById(R.id.DisNew);
            ImgNew = itemView.findViewById(R.id.ImgNew);

        }
    }
}
