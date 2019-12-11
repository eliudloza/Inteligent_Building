package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PuertaActivity extends AppCompatActivity implements Switch.OnClickListener  {

    Window window;
    String urlPuerta1 = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.puerta-1/data";
    String urlPuerta2 = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.puerta-2/data";
    String urlPuerta3 = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.puerta-3/data";
    String urlPuertaCorrediza = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.puerta-corrediza/data";

    protected RequestQueue fRequestQueue;
    private VolleySingleton volley;

    Switch swOnOff_P1;
    Switch swOnOff_P2;
    Switch swOnOff_P3;
    Switch swOnOff_CZA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puerta);

        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPuerta));
        }

        volley = VolleySingleton.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        swOnOff_P1 = (Switch)findViewById(R.id.swUno);
        swOnOff_P2 = (Switch)findViewById(R.id.swDos);
        swOnOff_P3 = (Switch)findViewById(R.id.swTres);
        swOnOff_CZA = (Switch)findViewById(R.id.swCuatro);

    }

    public void AbrirCerrar_Puerta1(){
        if (swOnOff_P1.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta1, data, new Response.Listener<JSONObject>() {
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
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "OFF");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta1, data, new Response.Listener<JSONObject>() {
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
    public void AbrirCerrar_Puerta2(){
        if (swOnOff_P2.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta2, data, new Response.Listener<JSONObject>() {
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
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "OFF");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta2, data, new Response.Listener<JSONObject>() {
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
    public void AbrirCerrar_Puerta3(){
        if (swOnOff_P3.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta3, data, new Response.Listener<JSONObject>() {
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
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "OFF");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuerta3, data, new Response.Listener<JSONObject>() {
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
    public void AbrirCerrar_PuertaCZA(){
        if (swOnOff_CZA.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuertaCorrediza, data, new Response.Listener<JSONObject>() {
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
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "OFF");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, urlPuertaCorrediza, data, new Response.Listener<JSONObject>() {
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
        switch (v.getId()){
            case R.id.swUno:
                AbrirCerrar_Puerta1();
                break;
            case R.id.swDos:
                AbrirCerrar_Puerta2();
                break;
            case R.id.swTres:
                AbrirCerrar_Puerta3();
                break;
            case R.id.swCuatro:
                AbrirCerrar_PuertaCZA();
                break;
        }
    }
}
