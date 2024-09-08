package br.edu.fatec.restaurante;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.Format;

public class MainActivity extends AppCompatActivity {

    EditText edtConsumo, edtArtistico, edtDividir;
    Button btnCalcular;
    TextView txtTaxa, txtTotal, txtPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtConsumo = findViewById(R.id.edtConsumo);
        edtArtistico = findViewById(R.id.edtArtistico);
        edtDividir = findViewById(R.id.edtDividir);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtTaxa = findViewById(R.id.txtTaxa);
        txtTotal= findViewById(R.id.txtTotal);
        txtPessoa = findViewById(R.id.txtPessoa);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(edtArtistico.getText().length() > 0 && edtDividir.getText().length() > 0 && edtConsumo.getText().length() > 0){
                        double taxaServico = Double.parseDouble(edtConsumo.getText().toString()) * 0.1;
                        double contaTotal = Double.parseDouble(edtConsumo.getText().toString()) + Double.parseDouble(edtArtistico.getText().toString()) + taxaServico;
                        double valorPessoa = contaTotal / Integer.parseInt(edtDividir.getText().toString());

                        txtTaxa.setText(String.format("%.2f", taxaServico));
                        txtTotal.setText(String.format("%.2f", contaTotal));
                        txtPessoa.setText(String.format("%.2f", valorPessoa));
                    } else {
                        aviso();
                    }
                } catch (Exception e){
                    erro();
                }


            }
        });
    }

    private void aviso(){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Campos em Branco!");
        builder.setMessage("Preencha todos os campos por gentileza!");
        alerta = builder.create();
        alerta.show();
    }

    private void erro(){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dados não Aceitos!");
        builder.setMessage("Preencha os campos com números!");
        alerta = builder.create();
        alerta.show();
    }
}