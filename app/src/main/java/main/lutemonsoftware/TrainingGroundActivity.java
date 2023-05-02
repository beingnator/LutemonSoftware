package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainingGroundActivity extends AppCompatActivity {
    private Context context = this;
    private ArrayList<Lutemon> lutemons;
    private LutemonListAdapter adapter;
    private Lutemon lutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_ground);

        TextView lutemonName = findViewById(R.id.txtTrainName);
        ImageView lutemonLogo = findViewById(R.id.imgTrainImg);

        lutemons = Storage.getInstance().getLutemons();

        adapter = new LutemonListAdapter(this, lutemons);

        if ( Storage.getNumberOfSelectedLutemons() != 1 ) {
            Toast.makeText(context, "Valitse listauksesta -YKSI- Lutemon, jota haluat treenata!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            lutemon = Storage.getFirstSelectedLutemon();
            lutemon = Storage.getFirstSelectedLutemon();
            lutemonName.setText(lutemon.getName());
            lutemonLogo.setImageResource(lutemon.getImage());
        }

    }

    public void startTraining(View view) {
        RadioGroup rgAttDef = findViewById(R.id.rgAttDef);

        int attDefValue = -1;
        Lutemon lutemon = Storage.getInstance().getFirstSelectedLutemon();

        switch (rgAttDef.getCheckedRadioButtonId()) {
            case R.id.rbAttack:
                attDefValue = 0;
                lutemon.train(attDefValue);
                Toast.makeText(context, "Hyökkäyksen treenaus suoritettu!", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbDefense:
                attDefValue = 1;
                lutemon.train(attDefValue);
                Toast.makeText(context, "Puolustuksen treenaus suoritettu!", Toast.LENGTH_LONG).show();
                break;
        }

        if (attDefValue == -1) {
            Toast.makeText(context, "Valitse hyökkäys tai puolustus ennen treenausta!", Toast.LENGTH_LONG).show();
        } else {
            adapter.notifyDataSetChanged();
        }

    }

}
