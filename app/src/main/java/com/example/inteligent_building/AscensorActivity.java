package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
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

public class AscensorActivity extends AppCompatActivity implements View.OnClickListener {

    Window window;
    Button btnSubir;
    Button btnBajar;
    String url = "https://io.adafruit.com/api/v2/Raul302/feeds/edificio-domotico.elevador/data";
    protected RequestQueue fRequestQueue;
    private VolleySingleton volley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ascensor);

        btnSubir = (Button)findViewById(R.id.btnSubir);
        btnBajar = (Button)findViewById(R.id.btnBajar);

        volley = VolleySingleton.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        if (Build.VERSION.SDK_INT >= 21){
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAscensor));
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSubir:
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

                break;
            case R.id.btnBajar:
                final JSONObject data2 = new JSONObject();

                try {
                    data2.put("value", "OFF");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest(Request.Method.POST, url, data2, new Response.Listener<JSONObject>() {
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
                fRequestQueue.add(jsonObjectRequest2);
                break;
        }
    }
}
