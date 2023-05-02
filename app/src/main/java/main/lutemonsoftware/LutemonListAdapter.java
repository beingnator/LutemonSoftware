package main.lutemonsoftware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<ListViewHolder>{
    private Context context;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private int pos;


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
        holder.imgPicture.setImageResource(lutemons.get(position).image);
        holder.textName.setText(lutemons.get(position).getName() + " (" + lutemons.get(position).getColor() + ")");
        holder.textAttack.setText(String.valueOf("Hyökkäys: " + lutemons.get(position).getAttack()));
        holder.textDefence.setText(String.valueOf("Puolustus: " + lutemons.get(position).getDefence()));
        holder.textHealth.setText(String.valueOf("Elämä: " + lutemons.get(position).getHealth()));
        holder.textExperienceAttack.setText(String.valueOf("Hyökkäyskokemus: " + lutemons.get(position).getExperienceAttack()));
        holder.textExperienceDefence.setText(String.valueOf("Puolustuskokemus: " + lutemons.get(position).getExperienceDefence()));
        holder.textWins.setText(String.valueOf("Voitot/häviöt: " + lutemons.get(position).getBattlesWon() + "/" + lutemons.get(position).getBattlesLost()));


        // Setting selection text background color to match the Lutemon's selection status
        pos = holder.getAdapterPosition();
        if (Storage.getLutemon(pos).getSelectionStatus() == 0) {
            holder.textSelection.setBackgroundColor(Color.TRANSPARENT);
        }
        else {
            holder.textSelection.setBackgroundColor(Color.GRAY);
        }

        holder.textSelection.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pos = holder.getAdapterPosition();
                if ( Storage.getLutemon(pos).getSelectionStatus() == 1 ) {
                    Storage.getLutemon(pos).setSelectionStatus(0);
                    holder.textSelection.setBackgroundColor(Color.TRANSPARENT);
                    System.out.println("heipähei. Pitäisi olla läpinäkyvä");
                }
                else {
                    System.out.println("Valinta ilmaisimen arvo: " + Storage.getLutemon(pos).getSelectionStatus());
                    Storage.getLutemon(pos).setSelectionStatus(1);
                    holder.textSelection.setBackgroundColor(Color.GRAY);
                    System.out.println("Valinta ilmaisimen arvo: " + Storage.getLutemon(pos).getSelectionStatus());
                    System.out.println("Lutemoneja : " + Lutemon.getNumberOfCreatedLutemons());
                }
                Storage.saveLutemons(context);
            }
        });


    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

}
