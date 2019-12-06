package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Switch;

public class PuertaActivity extends AppCompatActivity implements Switch.OnClickListener  {

    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puerta);

        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPuerta));
        }

    }


    @Override
    public void onClick(View v) {
        Switch controls = (Switch) findViewById(v.getId());
        switch (v.getId()){
            case R.id.swUno:

                break;

        }
    }
}
