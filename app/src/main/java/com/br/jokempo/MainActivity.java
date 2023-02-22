package com.br.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView saida,maquina,jogador;
    int contMaquina;
    int contJogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageSaida);
        saida = findViewById(R.id.txtSaida);
        maquina = findViewById(R.id.saidaMaquina);
        jogador = findViewById(R.id.saidaJogador);
        contMaquina = 0;
        contJogador = 0;
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");

    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String selecionada) {
        String[] opcs = {
                "pedra",
                "papel",
                "tesoura"
        };
        int numero = new Random().nextInt(3);
        String opcao = opcs[numero];

        switch (opcao) {
            case "pedra":
                image.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                image.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                image.setImageResource(R.drawable.tesoura);
                break;
        }

        if (selecionada.equals("pedra") && opcao.equals("pedra")) {
            saida.setText("Empate!!!");

        } else if (selecionada.equals("pedra") && opcao.equals("papel")) {
            contMaquina+=1;
            saida.setText("Perdeu!!!");
            maquina.setText(String.valueOf(contMaquina));

        } else if (selecionada.equals("pedra") && opcao.equals("tesoura")) {
            contJogador+=1;
            saida.setText("GANHOU!!!");
            jogador.setText(String.valueOf(contJogador));


        } else if (selecionada.equals("papel") && opcao.equals("papel")) {
            saida.setText("Empate!!!");

        }else if (selecionada.equals("papel") && opcao.equals("pedra")) {
            contJogador+=1;
            saida.setText("GANHOU!!!");
            jogador.setText(String.valueOf(contJogador));

        }else if (selecionada.equals("papel") && opcao.equals("tesoura")) {
            contMaquina+=1;
            saida.setText("Perdeu!!!");
            maquina.setText(String.valueOf(contMaquina));

        }else if (selecionada.equals("tesoura") && opcao.equals("tesoura")) {
            saida.setText("Empate!!!");

        }else if (selecionada.equals("tesoura") && opcao.equals("papel")) {
            contJogador+=1;
            saida.setText("GANHOU!!!");
            jogador.setText(String.valueOf(contJogador));

        }else if (selecionada.equals("tesoura") && opcao.equals("pedra")) {
            contMaquina+=1;
            saida.setText("Perdeu!!!");
            maquina.setText(String.valueOf(contMaquina));
        }else{
            contMaquina+=1;
            saida.setText("Perdeu!!!");
            maquina.setText(String.valueOf(contMaquina));

        }



    }

    public void zerarContagem(View view){
        contMaquina = 0;
        contJogador = 0;
        maquina.setText(String.valueOf(contMaquina));
        jogador.setText(String.valueOf(contJogador));


    }
}