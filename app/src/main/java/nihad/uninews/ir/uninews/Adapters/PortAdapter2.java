package nihad.uninews.ir.uninews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nihad.uninews.ir.uninews.Models.ItemPort2;
import nihad.uninews.ir.uninews.Models.Reshte;
import nihad.uninews.ir.uninews.R;

public class PortAdapter2 extends RecyclerView.Adapter<PortAdapter2.ViewHolder> {

    private Context context;
    private List<Reshte> items;

    public PortAdapter2(Context context, List<Reshte> items) {
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item_port2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title_tab2.setText(items.get(i).getReshteNam());
        viewHolder.Dis_tab2.setText(items.get(i).getReshteId());

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_tab2;
        TextView Dis_tab2;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tab2 = itemView.findViewById(R.id.title_tab2);
            Dis_tab2 = itemView.findViewById(R.id.Dis_tab2);
        }
    }
}
