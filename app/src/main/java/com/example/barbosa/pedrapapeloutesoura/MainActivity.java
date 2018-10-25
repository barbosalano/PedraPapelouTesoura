package com.example.barbosa.pedrapapeloutesoura;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        // Gerar uma opção aleatoria para o App

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel" :
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if ( //app ganhador
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura") ||
                (escolhaApp == "tesoura" && escolhaUsuario =="papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra")

                ){
            textoResultado.setText("Resultado: Você perdeu :( ");

        }else if (// app perdedor
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") ||
               (escolhaUsuario == "tesoura" && escolhaApp =="papel") ||
                 (escolhaUsuario == "papel" && escolhaApp == "pedra")


                ){ textoResultado.setText("Resultado: Você ganhou :) ");

        }else {//empate
            textoResultado.setText("Resultado: Empatamos :| ");
        }

    }
}
