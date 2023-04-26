package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TrainingGroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_ground);
    }

    public void startTraining(View view) {
        RadioGroup rgFighters = findViewById(R.id.rgFighters);
        RadioGroup rgAttDef = findViewById(R.id.rgAttDef);
        Button btnTraining = findViewById(R.id.btnTraining);
        TextView txtTraining = findViewById(R.id.txtTraining);
    }

}
