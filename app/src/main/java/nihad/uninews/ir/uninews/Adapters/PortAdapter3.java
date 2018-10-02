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

import nihad.uninews.ir.uninews.Models.Dars;
import nihad.uninews.ir.uninews.Models.ItemPort3;
import nihad.uninews.ir.uninews.R;

public class PortAdapter3 extends RecyclerView.Adapter<PortAdapter3.ViewHolder> {

    private Context context;
    private List<Dars> items;

    public PortAdapter3(Context context, List<Dars> items) {
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item_port3, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title_tab3.setText(items.get(i).getDarsNam());
        viewHolder.Dis_tab3.setText(items.get(i).getMaqtaeNam());

    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title_tab3;
        TextView Dis_tab3;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tab3 = itemView.findViewById(R.id.title_tab3);
            Dis_tab3 = itemView.findViewById(R.id.Dis_tab3);
        }
    }
}
