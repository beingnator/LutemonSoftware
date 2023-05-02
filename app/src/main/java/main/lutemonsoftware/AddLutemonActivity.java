package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AddLutemonActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addLutemon(View view) {
        RadioButton btnWhite = findViewById(R.id.btnWhite);
        RadioButton btnGreen = findViewById(R.id.btnGreen);
        RadioButton btnPink = findViewById(R.id.btnPink);
        RadioButton btnOrange = findViewById(R.id.btnOrange);
        RadioButton btnBlack = findViewById(R.id.btnBlack);
        Button btnAddLutemon = findViewById(R.id.btnAddNewLutemon);
        EditText txtName = findViewById(R.id.editTxtName);
        RadioGroup rgLutemonColor = findViewById(R.id.rgLutemonColor);

        switch (rgLutemonColor.getCheckedRadioButtonId()) {
            case R.id.btnWhite:
                Storage.getInstance().addLutemon(new White(txtName.getText().toString()));
                System.out.println("Lutemonin luominen onnistui.");
                Storage.getInstance().saveLutemons(this);
                break;
            case R.id.btnGreen:
                Storage.getInstance().addLutemon(new Green(txtName.getText().toString()));
                System.out.println("Lutemonin luominen onnistui.");
                Storage.getInstance().saveLutemons(this);
                break;
            case R.id.btnPink:
                Storage.getInstance().addLutemon(new Pink(txtName.getText().toString()));
                System.out.println("Lutemonin luominen onnistui.");
                Storage.getInstance().saveLutemons(this);
                break;
            case R.id.btnOrange:
                Storage.getInstance().addLutemon(new Orange(txtName.getText().toString()));
                System.out.println("Lutemonin luominen onnistui.");
                Storage.getInstance().saveLutemons(this);
                break;
            case R.id.btnBlack:
                Storage.getInstance().addLutemon(new Black(txtName.getText().toString()));
                System.out.println("Lutemonin luominen onnistui.");
                Storage.getInstance().saveLutemons(this);
                break;
        }

        context = AddLutemonActivity.this;
        Toast.makeText(context, "Lutemon lisätty!", Toast.LENGTH_LONG).show();
    }

    public void switchBackToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}