package main.lutemonsoftware;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    TextView textName, textAttack, textDefence, textHealth, textExperienceAttack, textExperienceDefence;
    ImageView imgPicture;
    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        imgPicture = itemView.findViewById(R.id.imgPicture);
        textName = itemView.findViewById(R.id.txtName);
        textAttack = itemView.findViewById(R.id.txtAttack);
        textDefence = itemView.findViewById(R.id.txtDefence);
        textHealth = itemView.findViewById(R.id.txtHealth);
        textExperienceAttack = itemView.findViewById(R.id.txtExperienceAttack);
        textExperienceDefence = itemView.findViewById(R.id.txtExperienceDefence);

    }
}
