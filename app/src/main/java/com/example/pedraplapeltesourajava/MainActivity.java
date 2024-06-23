package com.example.pedraplapeltesourajava;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void selecionarPedra(View view) {
        verificarGanhador("pedra");
    }
    public void selecionarPapel(View view) {
        verificarGanhador("papel");
    }
    public void selecionarTesoura(View view) {
        verificarGanhador("tesoura");
    }

    private String gerarEscolhaAleatoria() {

        String[] itens = {"pedra","papel","tesoura"};

        ImageView imageApp = findViewById(R.id.img_padrao);

        int numeroAleatorio = new Random().nextInt(3);
        String escolhaApp = itens[numeroAleatorio];

        switch (escolhaApp){
            case "pedra":
                imageApp.setImageResource(R.drawable.pedra);
            break;

            case "papel":
                imageApp.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageApp.setImageResource(R.drawable.tesoura);
                break;

        }
        return escolhaApp;
    }
    private void verificarGanhador(String escolhaDoUsuario) {

        String escolhaApp = gerarEscolhaAleatoria();
        TextView textResultado = findViewById(R.id.text_resultado);

        if(
                (escolhaApp == "pedra" && escolhaDoUsuario == "tesoura") ||
                (escolhaApp == "papel" && escolhaDoUsuario == "pedra") ||
                (escolhaApp == "tesoura" && escolhaDoUsuario == "papel")
        ){
            textResultado.setText("O App Venceu :(");
        } else if(
                        (escolhaDoUsuario == "pedra" && escolhaApp == "tesoura") ||
                        (escolhaDoUsuario == "papel" && escolhaApp == "pedra") ||
                        (escolhaDoUsuario== "tesoura" && escolhaApp == "papel")
        )  {
textResultado.setText("Voce venceu!! :)");

        }else{
            textResultado.setText("Empatamos ;)");
        }
    }


}