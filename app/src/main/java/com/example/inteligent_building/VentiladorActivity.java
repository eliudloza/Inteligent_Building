package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Switch;
import android.widget.Toast;

public class VentiladorActivity extends AppCompatActivity implements View.OnClickListener {

    Window window;
    Switch swOnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventilador);

        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorVentilador));
        }
        swOnOff = (Switch)findViewById(R.id.swOnOff);

    }

    public void encender_Apagar(){
        String swOn, swOff;

        if (swOnOff.isChecked()){
            swOn = swOnOff.getTextOn().toString();
            Toast mensaje = Toast.makeText(getApplicationContext(), swOn , Toast.LENGTH_SHORT);
            mensaje.show();
        }else {
            swOff = swOnOff.getTextOff().toString();
            Toast mensaje = Toast.makeText(getApplicationContext(), swOff , Toast.LENGTH_SHORT);
            mensaje.show();
        }

    }


    @Override
    public void onClick(View v) {
        encender_Apagar();
    }
}
