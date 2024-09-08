package br.edu.fatec.bandeiras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class Tela1 extends AppCompatActivity {

    ImageView img;
    Button btnResponder;
    RadioButton rad1, rad2, rad3, rad4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        img = findViewById(R.id.img);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        rad3 = findViewById(R.id.rad3);
        rad4 = findViewById(R.id.rad4);
        btnResponder = findViewById(R.id.btnResponder);
    }
}