package main.lutemonsoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);
    }

    public void addUser(View view) {
        Button btnWhite = findViewById(R.id.btnWhite);
        Button btnGreen = findViewById(R.id.btnGreen);
        Button btnPink = findViewById(R.id.btnPink);
        Button btnOrange = findViewById(R.id.btnOrange);
        Button btnBlack = findViewById(R.id.btnBlack);
        Button btnAddLutemon = findViewById(R.id.btnAddNewLutemon);
        EditText txtName = findViewById(R.id.editTxtName);
        RadioGroup rgLutemonColor = findViewById(R.id.rgLutemons);

        switch (rgLutemonColor.getCheckedRadioButtonId()) {
            case R.id.btnWhite:
                //hae storagesta lutemon
                break;
            case R.id.btnGreen:
                //hae storagesta lutemon
                break;
            case R.id.btnPink:
                //hae storagesta lutemon
                break;
            case R.id.btnOrange:
                //hae storagesta lutemon
                break;
            case R.id.btnBlack:
                //hae storagesta lutemon
                break;
                // lutemonien tallentaminen
        }
    }
}