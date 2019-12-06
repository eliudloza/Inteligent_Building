package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class AscensorActivity extends AppCompatActivity implements View.OnClickListener {

    Window window;
    Button btnSubir;
    Button btnBajar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascensor);

        btnSubir = (Button)findViewById(R.id.btnSubir);
        btnBajar = (Button)findViewById(R.id.btnBajar);

        btnSubir.setOnClickListener(this);
        btnBajar.setOnClickListener(this);


        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAscensor));
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubir:
                Toast mensaje1 = Toast.makeText(getApplicationContext(),"Subiendo...", Toast.LENGTH_SHORT);
                mensaje1.show();
                break;
            case R.id.btnBajar:
                Toast mensaje2 = Toast.makeText(getApplicationContext(),"Bajando...", Toast.LENGTH_SHORT);
                mensaje2.show();
                break;
        }
    }
}
