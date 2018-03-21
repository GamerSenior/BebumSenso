package com.facol.giovani.bebumsenso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nome;
    private DatePicker nascimento;
    private Spinner bebida;
    private List<String> bebidas = new ArrayList<>();
    private RadioGroup fumante;
    private SeekBar nivelBebum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.nome);
        nascimento = findViewById(R.id.nascimento);
        bebida = findViewById(R.id.bebidaSpinner);
        fumante = findViewById(R.id.fumante);
        nivelBebum = findViewById(R.id.seekBar);

        bebidas.add("Cerveja");
        bebidas.add("Vodka");
        bebidas.add("Tequila");
        bebidas.add("Skol bicha");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, bebidas);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        bebida.setAdapter(arrayAdapter);
    }

    public void save(View v){
        Intent intent = new Intent(this, DisplayActivity.class);
        intent.putExtra("nome", nome.getText().toString());

        String dataNascimento = "";
        try {
            dataNascimento = nascimento.getDayOfMonth() + "/" + nascimento.getMonth() + "/" + nascimento.getYear();
        }catch (Exception e){
        }

        intent.putExtra("dataNascimento", dataNascimento);
        intent.putExtra("bebida", bebida.getSelectedItem().toString());

        nivelBebum.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int nivel= 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                nivel = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast toast = new Toast(MainActivity.this);
                toast.setText("Nivel do Bebum: "+nivel);
                toast.show();
            }
        });

        switch(fumante.getCheckedRadioButtonId()){
            case R.id.radioSim:
                intent.putExtra("fumante", true);
                break;
            default:
                intent.putExtra("fumante", false);
                break;
        }

    }
}
