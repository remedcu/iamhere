package com.remedcu.user.iamhere;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class send extends AppCompatActivity {

    private Vibrator vib;
    Animation animShake;
    TextInputLayout username;
    Button send;
    EditText editText;
    private static final String LOGIN_URL = "http://wealthwrite.net/send.php";

    public static final String KEY_NAME = "Username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        username = (TextInputLayout) findViewById(R.id.Username);
        send = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shakei);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

    }

    private void submitForm() {
        final String Name = editText.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        Toast.makeText(send.this, response, Toast.LENGTH_SHORT).show();
                        if (response.equalsIgnoreCase("found")) {
//                            final String Use = "Are you sure you want to send to " + Name + "?";
//                            Toast.makeText(getApplicationContext(), Use, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(send.this, Sendconfirm.class);
                            Bundle bundle=new Bundle();
                            bundle.putString("usernames",Name);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(send.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_NAME, Name);

                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

        //   Toast.makeText(getApplicationContext(),
        //    "You are logged in !!", Toast.LENGTH_SHORT).show();
    }
}
