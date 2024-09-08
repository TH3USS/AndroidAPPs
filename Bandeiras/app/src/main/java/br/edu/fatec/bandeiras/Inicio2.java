package br.edu.fatec.bandeiras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Inicio2 extends AppCompatActivity {

    Button btnSair, btnIniciar;

    EditText edtNome;

    Intent it;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio2);

        btnSair = findViewById(R.id.btnSair);
        btnIniciar = findViewById(R.id.btnIniciar);
        edtNome = findViewById(R.id.edtNome);

        edtNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (edtNome.getText().length() <= 0) btnIniciar.setEnabled(false);
                else btnIniciar.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it = new Intent(getApplicationContext(), Ranking.class);
                startActivity(it);
            }
        });
    }

}