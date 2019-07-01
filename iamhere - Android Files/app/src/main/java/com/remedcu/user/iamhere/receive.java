package com.remedcu.user.iamhere;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class receive extends AppCompatActivity {
TextView Username;
    Button accept;
    Button check;
    private static final String LOGIN_URL = "http://wealthwrite.net/receiveconfirm.php";
    private static final String LOGIN_URLS = "http://wealthwrite.net/receiveconfirms.php";
    public static final String KEY_MYNAME = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        Username=(TextView)findViewById(R.id.textView6);
        accept=(Button)findViewById(R.id.button);
        check=(Button)findViewById(R.id.button4);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForms();
            }
        });
    }

    private void submitForm() {
        SharedPreferences sharedPreferences = receive.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
        Toast.makeText(getApplicationContext(), KEY_MYUSERNAME, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("success")) {
                            Intent intent = new Intent(receive.this, NavigationActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(receive.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            protected Map<String,String> getParams(){
                SharedPreferences sharedPreferences = receive.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_MYNAME,KEY_MYUSERNAME);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    private void submitForms() {
        SharedPreferences sharedPreferences = receive.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
        Toast.makeText(getApplicationContext(), KEY_MYUSERNAME, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URLS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("Username does not exist")) {
                            Toast.makeText(getApplicationContext(), "No username found", Toast.LENGTH_SHORT).show();
                        } else {
                            TextView textView = (TextView) findViewById(R.id.textView6);
                            textView.setText(response);
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(receive.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            protected Map<String,String> getParams(){
                SharedPreferences sharedPreferences = receive.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_MYNAME,KEY_MYUSERNAME);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
