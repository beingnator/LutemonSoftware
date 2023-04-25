package main.lutemonsoftware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<ListViewHolder>{
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.textName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.textAttack.setText(String.valueOf("Hyökkäys: " + lutemons.get(position).getAttack()));
        holder.textDefence.setText(String.valueOf("Puolustus: " + lutemons.get(position).getDefence()));
        holder.textHealth.setText(String.valueOf("Elämä: " + lutemons.get(position).getHealth()));
        holder.textExperienceAttack.setText(String.valueOf("Hyökkäyskokemus: " + lutemons.get(position).getExperienceAttack()));
        holder.textExperienceDefence.setText(String.valueOf("Puolustuskokemus: " + lutemons.get(position).getExperienceDefence()));

    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
