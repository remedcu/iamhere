package com.remedcu.user.iamhere;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputLayout;
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
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.HashMap;
import java.util.Map;
public class Sendconfirm extends AppCompatActivity {
    Button send;
    private static final String LOGIN_URL = "http://wealthwrite.net/sendconfirm.php";
    public static final String KEY_NAME = "Username";
    public static final String KEY_MYNAME = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendconfirm);
        Location location = null;
        send = (Button) findViewById(R.id.button3);
        Bundle bundle = getIntent().getExtras();
        final String Name = bundle.getString("usernames");
        TextView textView1 = (TextView) findViewById(R.id.textView9);
        textView1.setText(Name);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        SharedPreferences sharedPreferences = Sendconfirm.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
        Bundle bundle = getIntent().getExtras();
        final String Name = bundle.getString("usernames");
        Toast.makeText(getApplicationContext(), KEY_MYUSERNAME, Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.equalsIgnoreCase("success")) {
                            Intent intent = new Intent(Sendconfirm.this, NavigationActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Sendconfirm.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            protected Map<String,String> getParams(){
                SharedPreferences sharedPreferences = Sendconfirm.this.getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
                String KEY_MYUSERNAME = sharedPreferences.getString(Config.EMAIL_SHARED_PREF,"Not Found");
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_NAME,Name);
                params.put(KEY_MYNAME,KEY_MYUSERNAME);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
