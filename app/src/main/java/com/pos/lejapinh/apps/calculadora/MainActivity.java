package com.pos.lejapinh.apps.calculadora;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_expression;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnSum, btnSub, btnDiv, btnMulti, btnResult, btnReset, btnHistory;
    TextView txtMessage;

    int num1, num2, result;
    String operation, expression;
    ArrayList<String> results;
    Boolean isCalculed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeComponents();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText(btn9);
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum1(btnSum);
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum1(btnSub);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum1(btnDiv);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum1(btnMulti);
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNum2();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, HistoryActivity.class);
                i.putStringArrayListExtra("History", results);
                startActivity(i);
            }
        });
    }

    private void setText(Button b) {
        if (isCalculed) {
            edt_expression.setText("");
            isCalculed = false;
        }

        String numero = edt_expression.getText().toString();

        if(!numero.equals((""))) {
            if (numero.toCharArray()[0] == '0')
                edt_expression.setText(b.getText().toString());
            else
                edt_expression.setText(numero + b.getText().toString());
        }
        else
            edt_expression.setText(b.getText().toString());
    }

    private void setText(int r) {
        edt_expression.setText(r + "");
    }

    private void setNum1(Button b) {
        if(!edt_expression.getText().toString().equals("")) {
            operation = b.getText().toString();
            num1 = Integer.parseInt(edt_expression.getText().toString());
            expression = num1 + operation;

            edt_expression.setText("");
        }
    }

    private void setNum2() {
        try {
            if (!edt_expression.getText().toString().equals("")) {
                num2 = Integer.parseInt(edt_expression.getText().toString());
                calculate();
            }
        } catch (Exception ex) {
            txtMessage.setText("Erro: " + ex.getMessage());
        }
    }

    private void calculate() {
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

            default:
                break;
        }

        expression += num2 + " = " + result;
        addHistory();
        setText(result);
        isCalculed = true;
    }

    private void clear() {
        operation = "";
        num1 = 0;
        num2 = 0;
        result = 0;
        edt_expression.setText("");
    }

    private  void addHistory() {
        results.add(expression);
    }

    private void InitializeComponents() {
        edt_expression = (EditText)findViewById(R.id.edtExpression);
        btn0 = (Button)findViewById(R.id.btn0);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btnSum = (Button)findViewById(R.id.btnSum);
        btnSub = (Button)findViewById(R.id.btnSub);
        btnDiv = (Button)findViewById(R.id.btnDiv);
        btnMulti = (Button)findViewById(R.id.btnMulti);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnResult = (Button)findViewById(R.id.btnResult);
        btnHistory = (Button)findViewById(R.id.btnHistory);
        txtMessage = (TextView)findViewById(R.id.txtMessage);

        results = new ArrayList<String>();
        isCalculed = false;
    }
}
