package nihad.uninews.ir.uninews.Models;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nihad.uninews.ir.uninews.R;

public class AdapterUniList extends RecyclerView.Adapter<AdapterUniList.ViewHolder> {

    private Context context;
    private ArrayList<ItemUniList> items;

    AdapterUniList(Context context, ArrayList<ItemUniList> items) {
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.uni_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.Uni_text.setText(items.get(i).Uni_text);

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView Uni_text;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            Uni_text = itemView.findViewById(R.id.Uni_text);
        }
    }
}
