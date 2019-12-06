package com.example.inteligent_building;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private RequestQueue fRequestQueue;
    private VolleySingleton volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        volley = VolleySingleton.getInstance(this.getApplicationContext());
        fRequestQueue = volley.getRequestQueue();

        Button btnRegister = findViewById(R.id.btnRegistrar);
        btnRegister.setOnClickListener(this);

    }

    public void registro(){
        String url = "http://home4.uttics.com/api/registro";

        final JSONObject data = new JSONObject();
        EditText name=findViewById(R.id.ing_nombre);
        EditText email=findViewById(R.id.ing_email);
        EditText pass=findViewById(R.id.ing_password);

        try {
            data.put("name", name.getText());
            data.put("email",email.getText() );
            data.put("password",pass.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest =new JsonObjectRequest(Request.Method.POST, url, data, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(RegistroActivity.this,"Se Agrego correctamente",Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("OnErrorResponse1: ", error.toString());
            }
        });
        fRequestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onClick(View view) {
        registro();
    }
}
