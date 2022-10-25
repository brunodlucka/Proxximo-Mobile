package com.example.proxximo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText nome,cpf;
    private RadioButton auxiliar,tecnico,enfermeiro;
    private TextView resultadonome,resultadocpf,resultadotipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editNome);
        cpf = findViewById(R.id.editCpf);
        auxiliar = findViewById(R.id.botao_auxiliar);
        tecnico = findViewById(R.id.botao_tecnico);
        enfermeiro = findViewById(R.id.botao_enfermeiro);

        resultadonome = findViewById(R.id.resultadonome);
        resultadocpf = findViewById(R.id.resultadocpf);
        resultadotipo = findViewById(R.id.resultadotipo);

        Button Agendar = findViewById(R.id.bt_agendar);

        Agendar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String editNome = nome.getText().toString();
                String editCpf = cpf.getText().toString();

                if (editNome.isEmpty() || editCpf.isEmpty()) {
                    Snackbar.make(v,"insira o nome e o cpf",Snackbar.LENGTH_SHORT).show();

                }else RadioButtonSelecionado(v);
            }
        });
    }

    private void RadioButtonSelecionado(View view) {

        String editNome = nome.getText().toString();
        String editCpf = cpf.getText().toString();

        if (auxiliar.isChecked()) {
            resultadonome.setText(editNome);
            resultadocpf.setText(editCpf);
            resultadotipo.setText("Tipo: Auxiliar de Enfermagem");

        } else if (tecnico.isChecked()) {
            resultadonome.setText(editNome);
            resultadocpf.setText(editCpf);
            resultadotipo.setText("Tipo: Técnico de Enfermagem");

        }  else if (enfermeiro.isChecked()) {
            resultadonome.setText(editNome);
            resultadocpf.setText(editCpf);
            resultadotipo.setText("Tipo: Enfermeiro");

        }else{
            Snackbar.make(view,"Escolha o tipo de inscrição",Snackbar.LENGTH_SHORT).show();
        }
    }
}