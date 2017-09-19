package orosco.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnSom,btnSub,btnMult,btnDiv,btnIgual,btnPonto,btnSinal,btnDel,btnAc;
    TextView textView;
    Operators operador = new Operators();
    CheckValues checkZero = new CheckValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.Button_1);
        btn2 = (Button)findViewById(R.id.Button_2);
        btn3 = (Button)findViewById(R.id.Button_3);
        btn4 = (Button)findViewById(R.id.Button_4);
        btn5 = (Button)findViewById(R.id.Button_5);
        btn6 = (Button)findViewById(R.id.Button_6);
        btn7 = (Button)findViewById(R.id.Button_7);
        btn8 = (Button)findViewById(R.id.Button_8);
        btn9 = (Button)findViewById(R.id.Button_9);
        btn0 = (Button)findViewById(R.id.Button_0);
        btnSub = (Button)findViewById(R.id.Button_Sub);
        btnSom = (Button)findViewById(R.id.Button_Soma);
        btnMult = (Button)findViewById(R.id.Button_Multi);
        btnDiv = (Button)findViewById(R.id.Button_Div);
        btnIgual = (Button)findViewById(R.id.Button_Igual);
        btnPonto = (Button)findViewById(R.id.Button_Dot);
        btnSinal = (Button)findViewById(R.id.Button_Sinal);
        btnDel = (Button)findViewById(R.id.Button_Del);
        btnAc = (Button)findViewById(R.id.Button_Ac);
        textView = (TextView) findViewById(R.id.TextViewDisplay);


        textView.setText(textView.getText(), TextView.BufferType.EDITABLE);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"1"));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"2"));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"3"));
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"4"));
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"5"));
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"6"));
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"7"));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"8"));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(checkZero.checkValues(textView.getText().toString(),"9"));
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (textView.length()==1 & textView.getText().toString().contains("0")){
                    //do nothing
                }else{
                    textView.append("0");
                }
            }
        });

        btnSom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(textView.getText().length()>0)
            {
                textView.setText(operador.checkOperators(textView.getText().toString()) + " + ");
            }
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(textView.getText().length()>0)
            {
                textView.setText(operador.checkOperators(textView.getText().toString()) + " - ");
            }else{
                textView.append("-");
            }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(textView.getText().length()>0)
            {
                textView.setText(operador.checkOperators(textView.getText().toString()) + " * ");
            }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            if(textView.getText().length()>0)
            {
                textView.setText(operador.checkOperators(textView.getText().toString()) + " ÷ ");
            }
            }
        });

        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //operador.setList(textView.getText().toString());
                //textView.setText(resultado);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String del = textView.getText().toString();
                if(textView.length()>0){
                    del = del.substring(0,del.length()-1);
                    textView.setText(del);
                }
            }
        });

        btnAc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText("");
            }
        });

        btnPonto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(textView.getText().length()==0){
                    textView.setText("0.");
                }else if(!textView.getText().toString().contains(".")){
                    textView.append(".");
                }

            }
        });


        btnSinal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String valor = textView.getText().toString();
                if(textView.length()>0) {
                    if (valor.contains(".")) {
                        double sinalDouble = Double.valueOf(valor);
                        sinalDouble = sinalDouble * -1;
                        textView.setText(String.valueOf(sinalDouble));
                    } else {
                        int sinalInt = Integer.valueOf(valor);
                        sinalInt = sinalInt * -1;
                        textView.setText(String.valueOf(sinalInt));
                    }
                }else{
                    textView.append("0");
                }

            }
        });

    }
}
