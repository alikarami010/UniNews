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

import nihad.uninews.ir.uninews.Models.ItemPort;
import nihad.uninews.ir.uninews.Models.Term;
import nihad.uninews.ir.uninews.R;

public class PortAdapter extends RecyclerView.Adapter<PortAdapter.ViewHolder> {

    private Context context;
    private  List<Term> items;

    public PortAdapter(Context context, List<Term> items) {
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item_port, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title_tab.setText(items.get(i).getTermNam());
        viewHolder.Dis_tab.setText(items.get(i).getTermID()+"");

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_tab;
        TextView Dis_tab;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tab = itemView.findViewById(R.id.title_tab);
            Dis_tab = itemView.findViewById(R.id.Dis_tab);
        }
    }
}
