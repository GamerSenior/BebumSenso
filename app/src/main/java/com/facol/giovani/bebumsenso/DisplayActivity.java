package com.facol.giovani.bebumsenso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        String nome = intent.getStringExtra()
                String dataNascimento = intent.getStringExtra()
        String bebida = intent.getStringExtra()
                String fumante = intent.getStringExtra()
    }


}
