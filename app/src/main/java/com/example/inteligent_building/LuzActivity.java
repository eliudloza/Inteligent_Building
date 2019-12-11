package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class LuzActivity extends AppCompatActivity implements Switch.OnClickListener {

    String url_SisAlum1 = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.sistema-de-alumbrado/data";
    String url_SisAlum2 = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.sistema-de-alumbrado-2/data";

    Switch swOnOff_A1;
    Switch swOnOff_A2;

    protected RequestQueue fRequestQueue;
    private VolleySingleton volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);

        volley = VolleySingleton.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        swOnOff_A1 = (Switch)findViewById(R.id.swUnoA1);
        swOnOff_A2 = (Switch)findViewById(R.id.swUnoA2);

    }

    public void EncenderApagar_A1(){
        if (swOnOff_A1.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_SisAlum1, data, new Response.Listener<JSONObject>() {
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
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_SisAlum1, data, new Response.Listener<JSONObject>() {
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
    public void EncenderApagar_A2(){
        if (swOnOff_A2.isChecked()){
            final JSONObject data = new JSONObject();
            try {
                data.put("value", "ON");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_SisAlum2, data, new Response.Listener<JSONObject>() {
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
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url_SisAlum2, data, new Response.Listener<JSONObject>() {
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
            case R.id.swUnoA1:
                EncenderApagar_A1();
                break;
            case R.id.swUnoA2:
                EncenderApagar_A2();
                break;
        }
    }
}
