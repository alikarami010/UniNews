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
import nihad.uninews.ir.uninews.Models.Item1;
import nihad.uninews.ir.uninews.R;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.ViewHolder> {

    private Context context;
    private List<Dars> items;

    public LessonsAdapter(Context context, List<Dars> items){
        this.context = context;
        this.items = items;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return new ViewHolder(inflater.inflate(R.layout.item1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.NameCourse.setText(items.get(position).getDarsNam());
        viewHolder.ProfessorSection.setText(items.get(position).getMaqtaeNam());
        viewHolder.NumCode.setText(items.get(position).getDarsId());
        if (position==0){
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) viewHolder.view.getLayoutParams();
            p.setMargins(15,0,45,0);
            viewHolder.view.requestLayout();

        }
        if (position==1){
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) viewHolder.view.getLayoutParams();
            p.setMargins(15,0,45,0);
            viewHolder.view.requestLayout();

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends  RecyclerView.ViewHolder{

        View view;
        TextView NameCourse;
        TextView ProfessorSection;
        TextView NumCode;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            NameCourse = itemView.findViewById(R.id.NameCourse);
            ProfessorSection = itemView.findViewById(R.id.ProfessorSection);
            NumCode = itemView.findViewById(R.id.NumCode);
        }
    }
}
