package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VentiladorActivity extends AppCompatActivity implements View.OnClickListener {

    Window window;
    Switch swOnOff;
    String url = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.sistema-ventilacion/data";
    protected RequestQueue fRequestQueue;
    private VolleySingleton volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventilador);

        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorVentilador));
        }
        swOnOff = (Switch)findViewById(R.id.swOnOff);
        volley = VolleySingleton.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

    }

    public void encender_Apagar(){
        String swOn, swOff;

        if (swOnOff.isChecked()){
            swOn = swOnOff.getTextOn().toString();
            Toast mensaje = Toast.makeText(getApplicationContext(), swOn , Toast.LENGTH_SHORT);
            mensaje.show();
            final JSONObject data = new JSONObject();

            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String token = response.getString("value");
                        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("OnErrorResponse1: ", error.toString());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("Content-Type", "application/json");
                    params.put("X-AIO-Key", "eb450dddcffa4952ba8e356d5595bfcc");

                    return params;
                }
            };

            fRequestQueue.add(jsonObjectRequest);

        }else {
            swOff = swOnOff.getTextOn().toString();
            Toast mensaje = Toast.makeText(getApplicationContext(), swOff , Toast.LENGTH_SHORT);
            mensaje.show();
            final JSONObject data = new JSONObject();

            try {
                data.put("value", "OFF");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        String token = response.getString("value");
                        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("OnErrorResponse1: ", error.toString());
                }
            }) {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("Content-Type", "application/json");
                    params.put("X-AIO-Key", "eb450dddcffa4952ba8e356d5595bfcc");

                    return params;
                }
            };
            fRequestQueue.add(jsonObjectRequest);

        }

    }


    @Override
    public void onClick(View v) {
        encender_Apagar();
    }
}
