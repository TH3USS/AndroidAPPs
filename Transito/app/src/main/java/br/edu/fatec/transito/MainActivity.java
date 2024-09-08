package br.edu.fatec.transito;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.media.Image;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4, btnProximo;
    private TextView txtQuestao;
    private ImageView img;

    private String aux, aux2, aux3;
    private int contador = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        img = findViewById(R.id.img);
        txtQuestao = findViewById(R.id.txtQuestao);
        btnProximo = findViewById(R.id.btnProximo);

        placa1();

        ColorFilter color1 = btn1.getBackground().getColorFilter();
        ColorFilter color2 = btnProximo.getBackground().getColorFilter();

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = btnProximo.getText().toString();
                if(text != "Recomeçar"){
                    proximo();
                } else {
                    contador = 0;
                    txtQuestao.setText(String.valueOf(contador));
                    btnProximo.setText("Próxima pergunta");
                    btnProximo.getBackground().setColorFilter(color2);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn1.getBackground().setColorFilter(color1);
                    btn2.getBackground().setColorFilter(color1);
                    btn3.getBackground().setColorFilter(color1);
                    btn4.getBackground().setColorFilter(color1);
                    placa1();
                }

            }
        });

    }

    public void placa1() {

        img.setImageResource(R.drawable.pedestre);
        aux = "1";
        aux2 = "Trânsito de pedestres";
        btn1.setText("Parada obrigatória");
        btn2.setText("Dê a preferência");
        btn3.setText("Sentido proibido");
        btn4.setText("Trânsito de pedestres");
    }

    public void placa2() {

        img.setImageResource(R.drawable.limite);
        aux = "2";
        aux2 = "Velocidade máxima permitida";
        btn1.setText("Estacionamento regulamentado");
        btn2.setText("Velocidade máxima permitida");
        btn3.setText("Uso obrigatório de corrente");
        btn4.setText("Proibido ultrapassar");
    }

    public void placa3() {

        img.setImageResource(R.drawable.sinuoso);
        aux = "3";
        aux2 = "Pista sinuosa à direita";
        btn1.setText("Alfândega");
        btn2.setText("Pista sinuosa à esquerda");
        btn3.setText("Estreitamento de pista ao centro");
        btn4.setText("Pista sinuosa à direita");
    }

    public void placa4() {

        img.setImageResource(R.drawable.deslisamento);
        aux = "4";
        aux2 = "Área com desmoronamento";
        btn1.setText("Área com desmoronamento");
        btn2.setText("Ponte estreita");
        btn3.setText("Área escolar");
        btn4.setText("Obras");
    }

    public void placa5() {

        img.setImageResource(R.drawable.esquerda);
        aux = "5";
        aux2 = "Proibido virar à esquerda";
        btn1.setText("Proibido virar à direita");
        btn2.setText("Proibido ultrapassar");
        btn3.setText("Proibido virar à esquerda");
        btn4.setText("Proibido trânsito de caminhões");
    }

    public void proximo(){
        if(aux.equals("1")) placa2();
        else if (aux.equals("2")) placa3();
        else if (aux.equals("3")) placa4();
        else if (aux.equals("4")) placa5();
        else if (aux.equals("5")) placa1();
    }

    public void btn1(View view){
        aux3 = btn1.getText().toString();
        if(aux2.equals(aux3)){
            contador = contador + 1;
            txtQuestao.setText(String.valueOf(contador));
            if(contador < 5){
                proximo();
            } else if (contador == 5) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                btn1.getBackground().setColorFilter(colorFilter);
                btn2.getBackground().setColorFilter(colorFilter);
                btn3.getBackground().setColorFilter(colorFilter);
                btn4.getBackground().setColorFilter(colorFilter);
                btnProximo.setText("Recomeçar");
                PorterDuffColorFilter colorFilter2 = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                btnProximo.getBackground().setColorFilter(colorFilter2);

            }

        }
        else
        {
            ColorFilter color = btn1.getBackground().getColorFilter();
            new CountDownTimer(1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    btn1.getBackground().setColorFilter(colorFilter);
                }
                public void onFinish() {
                    btn1.getBackground().setColorFilter(color);
                }
            }.start();

        }

    }

    public void btn2(View view){
        aux3 = btn2.getText().toString();
        if(aux2.equals(aux3)){
            contador = contador + 1;
            txtQuestao.setText(String.valueOf(contador));
            if(contador < 5){
                proximo();
            } else if (contador == 5) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                btn1.getBackground().setColorFilter(colorFilter);
                btn2.getBackground().setColorFilter(colorFilter);
                btn3.getBackground().setColorFilter(colorFilter);
                btn4.getBackground().setColorFilter(colorFilter);
                btnProximo.setText("Recomeçar");
                PorterDuffColorFilter colorFilter2 = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                btnProximo.getBackground().setColorFilter(colorFilter2);
            }
        }
        else
        {
            ColorFilter color = btn2.getBackground().getColorFilter();
            new CountDownTimer(1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    btn2.getBackground().setColorFilter(colorFilter);
                }
                public void onFinish() {
                    btn2.getBackground().setColorFilter(color);
                }
            }.start();

        }

    }

    public void btn3(View view){
        aux3 = btn3.getText().toString();
        if(aux2.equals(aux3)){
            contador = contador + 1;
            txtQuestao.setText(String.valueOf(contador));
            if(contador < 5){
                proximo();
            } else if (contador == 5) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                btn1.getBackground().setColorFilter(colorFilter);
                btn2.getBackground().setColorFilter(colorFilter);
                btn3.getBackground().setColorFilter(colorFilter);
                btn4.getBackground().setColorFilter(colorFilter);
                btnProximo.setText("Recomeçar");
                PorterDuffColorFilter colorFilter2 = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                btnProximo.getBackground().setColorFilter(colorFilter2);
            }
        }
        else
        {
            ColorFilter color = btn3.getBackground().getColorFilter();
            new CountDownTimer(1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    btn3.getBackground().setColorFilter(colorFilter);
                }
                public void onFinish() {
                    btn3.getBackground().setColorFilter(color);
                }
            }.start();

        }

    }

    public void btn4(View view){
        aux3 = btn4.getText().toString();
        if(aux2.equals(aux3)){
            contador = contador + 1;
            txtQuestao.setText(String.valueOf(contador));
            if(contador < 5){
                proximo();
            } else if (contador == 5) {
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
                btn1.getBackground().setColorFilter(colorFilter);
                btn2.getBackground().setColorFilter(colorFilter);
                btn3.getBackground().setColorFilter(colorFilter);
                btn4.getBackground().setColorFilter(colorFilter);
                btnProximo.setText("Recomeçar");
                PorterDuffColorFilter colorFilter2 = new PorterDuffColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                btnProximo.getBackground().setColorFilter(colorFilter2);
            }
        }
        else
        {
            ColorFilter color = btn4.getBackground().getColorFilter();
            new CountDownTimer(1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    btn4.getBackground().setColorFilter(colorFilter);
                }
                public void onFinish() {
                    btn4.getBackground().setColorFilter(color);
                }
            }.start();

        }

    }


}