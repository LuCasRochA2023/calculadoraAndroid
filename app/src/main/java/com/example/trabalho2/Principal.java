package com.example.trabalho2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    Button botao8;
    Button botao1;
    Button botao2;
    Button botao3;
    Button botao4;
    Button botao5;
    Button botao6;
    Button botao7;
    Button botao9;
    Button botao0;
    Button delete;
    Button equals;
    Button mul;
    Button div;
    Button soma;
    Button menos;
    TextView t1;

    String n1 = "", n2 = "", operacao = "";
    String resultado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botao0 = findViewById(R.id.btn0);
        botao1 = findViewById(R.id.btn1);
        botao2 = findViewById(R.id.btn2);
        botao3 = findViewById(R.id.btn3);
        botao4 = findViewById(R.id.btn4);
        botao5 = findViewById(R.id.btn5);
        botao6 = findViewById(R.id.btn6);
        botao7 = findViewById(R.id.btn7);
        botao8 = findViewById(R.id.btn8);
        botao9 = findViewById(R.id.btn9);
        delete = findViewById(R.id.bntDel);
        soma = findViewById(R.id.btnMais);
        div = findViewById(R.id.bntDiv);
        menos = findViewById(R.id.btnMenos);
        mul = findViewById(R.id.btnMult);

        equals = findViewById(R.id.btnEquals);
        t1 = findViewById(R.id.text);

        definirListeners(botao0, botao1, botao2, botao3, botao4, botao5, botao6, botao7, botao8, botao9, botao0, delete, soma, equals, menos, div, mul);
    }

    private void definirListeners(Button... buttons) {
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn1 || id == R.id.btn2 || id == R.id.btn3 || id == R.id.btn4 || id == R.id.btn5 ||
                id == R.id.btn6 || id == R.id.btn7 || id == R.id.btn8 || id == R.id.btn9 || id == R.id.btn0) {
            tratarNumero(((Button) view).getText().toString());
        } else if (id == R.id.btnMais || id == R.id.btnMenos || id == R.id.btnMult || id == R.id.bntDiv) {
            tratarOperacao(((Button) view).getText().toString());
        } else if (id == R.id.btnEquals) {
            calcularResultado();
        } else if (id == R.id.bntDel) {
            limparTudo();
        }
    }


    private void tratarNumero(String numero) {
        t1.append(numero);

        if (operacao.isEmpty()) {
            n1 += numero;
        } else {
            n2 += numero;
        }
    }

    private void tratarOperacao(String operacaoEscolhida) {
        if (!n1.isEmpty()) {
            t1.append(operacaoEscolhida);
            operacao = operacaoEscolhida;
        }
    }

    private void calcularResultado() {
        if (!n1.isEmpty() && !n2.isEmpty() && !operacao.isEmpty()) {
            Calculadora calc = new Calculadora();
            switch (operacao) {
                case "+":
                    resultado = calc.soma(n1, n2);
                    break;
                case "-":
                    resultado = calc.subtrai(n1, n2);
                    break;
                case "X":
                    resultado = calc.multiplica(n1, n2);
                    break;
                case "/":
                    resultado = calc.divide(n1, n2);
                    break;
            }
            t1.setText(resultado);
            n1 = resultado;
            n2 = "";
            operacao = "";
        }
    }

    private void limparTudo() {
        t1.setText("");
        n1 = "";
        n2 = "";
        operacao = "";
    }
}