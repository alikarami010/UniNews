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

import nihad.uninews.ir.uninews.Models.ItemPort1;
import nihad.uninews.ir.uninews.Models.Maghta;
import nihad.uninews.ir.uninews.R;

public class PortAdapter1 extends RecyclerView.Adapter<PortAdapter1.ViewHolder> {

    private Context context;
    private List<Maghta> items;

    public PortAdapter1(Context context,  List<Maghta> items) {
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item_port1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title_tab1.setText(items.get(i).getMaqtaeNam());
        viewHolder.Dis_tab1.setText(items.get(i).getMaqtaeID()+"");

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_tab1;
        TextView Dis_tab1;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tab1 = itemView.findViewById(R.id.title_tab1);
            Dis_tab1 = itemView.findViewById(R.id.Dis_tab1);
        }
    }
}
