package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener {

    Intent myIntent;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        /*getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);*/
        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorInicio));
        }
    }


    @Override
    public void onClick(View v) {
        ImageButton btn = (ImageButton)findViewById(v.getId());
        switch (v.getId()){

            case R.id.firstFrame:
                myIntent = new Intent(v.getContext(), PuertaActivity.class);
                startActivity(myIntent);
                break;

            case R.id.secondFrame:
                myIntent = new Intent(v.getContext(), VentiladorActivity.class);
                startActivity(myIntent);
                break;

            case R.id.thirdFrame:
                myIntent = new Intent(v.getContext(), LuzActivity.class);
                startActivity(myIntent);
                break;

            case R.id.quarterFrame:
                myIntent = new Intent(v.getContext(),AscensorActivity.class);
                startActivity(myIntent);
                break;
        }
    }
}
