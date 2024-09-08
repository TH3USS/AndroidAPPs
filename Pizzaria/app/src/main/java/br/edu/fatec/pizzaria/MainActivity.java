package br.edu.fatec.pizzaria;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtQ1,edtQ2,edtQ3,edtQ4;
    Button btnPedir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtQ1 = findViewById(R.id.edtQ1);
        edtQ2 = findViewById(R.id.edtQ2);
        edtQ3 = findViewById(R.id.edtQ3);
        edtQ4 = findViewById(R.id.edtQ4);
        btnPedir = findViewById(R.id.btnPedir);

        btnPedir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    double conta = 0;
                    if (
                            !edtQ1.getText().toString().equals("")
                                    &&!edtQ2.getText().toString().equals("")
                                    &&!edtQ3.getText().toString().equals("")
                                    &&!edtQ4.getText().toString().equals("")
                    ){
                        double valor1 = Double.parseDouble(edtQ1.getText().toString()) * 40.00;

                        double valor2 = Double.parseDouble(edtQ2.getText().toString()) * 55.00;

                        double valor3 = Double.parseDouble(edtQ3.getText().toString()) * 40.00;

                        double valor4 = Double.parseDouble(edtQ4.getText().toString()) * 50.00;

                        conta = valor1 + valor2 + valor3 + valor4;
                        pedido(conta);

                    } else if (
                            edtQ1.getHint().toString().equals("Quantidade")
                                    &&edtQ2.getHint().toString().equals("Quantidade")
                                    &&edtQ3.getHint().toString().equals("Quantidade")
                                    &&edtQ4.getHint().toString().equals("Quantidade")
                    ){
                        aviso();
                    }
                } catch (Exception e){
                    erro();
                }


            }
        });
    }

    private void pedido(double conta){
        AlertDialog alerta;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pedido Feito!");
        builder.setMessage(String.format("Valor de: R$%.2f", conta));
        alerta = builder.create();
        alerta.show();
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
        builder.setTitle("Dados Incorretos!");
        builder.setMessage("Preencha os campos com números!");
        alerta = builder.create();
        alerta.show();
    }
}