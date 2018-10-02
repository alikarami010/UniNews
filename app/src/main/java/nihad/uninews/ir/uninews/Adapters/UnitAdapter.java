package nihad.uninews.ir.uninews.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import nihad.uninews.ir.uninews.Models.Item3;
import nihad.uninews.ir.uninews.R;

public class UnitAdapter extends RecyclerView.Adapter<UnitAdapter.ViewHolder> {


    private Context context1;
    private ArrayList<Item3> items;

    public UnitAdapter(Context context, ArrayList<Item3> items) {
        this.context1 = context;
        this.items = items;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = (LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item3, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name_lessn.setText(items.get(position).name_lessn);
        viewHolder.time_o.setText(items.get(position).time_o);
        viewHolder.timeOff.setText(items.get(position).timeOff);
        viewHolder.timeOn.setText(items.get(position).timeOn);
        viewHolder.ClassCode.setText(items.get(position).ClassCode);
        viewHolder.ProfessorName.setText(items.get(position).ProfessorName);
        viewHolder.LesonCode.setText(items.get(position).LesonCode);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name_lessn;
        TextView time_o;
        TextView timeOff;
        TextView timeOn;
        TextView ClassCode;
        TextView ProfessorName;
        TextView LesonCode;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            name_lessn = itemView.findViewById(R.id.name_lessn);
            time_o = itemView.findViewById(R.id.time_o);
            timeOff = itemView.findViewById(R.id.timeOff);
            timeOn = itemView.findViewById(R.id.timeOn);
            ClassCode = itemView.findViewById(R.id.ClassCode);
            ProfessorName = itemView.findViewById(R.id.ProfessorName);
            LesonCode = itemView.findViewById(R.id.LesonCode);


        }
    }
}