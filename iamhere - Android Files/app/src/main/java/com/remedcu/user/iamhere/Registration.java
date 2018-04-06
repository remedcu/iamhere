package com.remedcu.user.iamhere;

import android.net.nsd.NsdManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

public class Registration extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private Vibrator vib;
    Animation animShake;
    private EditText signupInputName, signupInputEmail, signupInputPassword;
    private TextInputLayout signupInputLayoutName, signupInputLayoutEmail,
            signupInputLayoutPassword;
    private Button btnSignUp;
    ProgressDialog progress;
    private static final String LOGIN_URL = "http://wealthwrite.net/volleyRegister.php";

    public static final String KEY_NAME = "Username";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_PASSWORD = "Password";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signupInputLayoutName = (TextInputLayout) findViewById(R.id.signup_input_layout_name);
        signupInputLayoutEmail = (TextInputLayout) findViewById(R.id.signup_input_layout_email);
        signupInputLayoutPassword = (TextInputLayout) findViewById(R.id.signup_input_layout_password);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this, Login.class);
                startActivity(intent);
            }
        });

        signupInputName = (EditText) findViewById(R.id.signup_input_name);

        signupInputEmail = (EditText) findViewById(R.id.signup_input_email);
        signupInputPassword = (EditText) findViewById(R.id.signup_input_password);

        btnSignUp = (Button) findViewById(R.id.btn_signup);

        animShake = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.shakei);
        vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                submitForm();
                //Intent intent=new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.thingspeak/channels/84008.com"));
                //startActivity(intent);
            }
        });
    }

    //  public void serve(View v) {
    //   Intent i = new Intent();
    //     i.setClass(this, Register.class);
    //    startActivity(i);
    // }


    private void submitForm() {
        final String Name = signupInputName.getText().toString().trim();
        final String Email = signupInputEmail.getText().toString().trim();
        final String Password = signupInputPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST,LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Registration.this, response, Toast.LENGTH_SHORT).show();
                        if(response.equalsIgnoreCase("success")){
                            final String Use ="Welcome "+Name;
                            Toast.makeText(getApplicationContext(),Use,Toast.LENGTH_SHORT).show();
                            //Starting profile activity
//                          Toast.makeText(getApplicationContext(),"You are looking great today!",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(Registration.this,Login.class);
                            startActivity(intent);
                        }//else{
                        //  Intent intent = new Intent(Registration.this, MainActivity.class);
                        // startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Registration.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_NAME,Name);
                params.put(KEY_EMAIL, Email);
                params.put(KEY_PASSWORD,Password);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


        if (!checkName()) {
            signupInputName.setAnimation(animShake);
            signupInputName.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkEmail()) {
            signupInputEmail.setAnimation(animShake);
            signupInputEmail.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }
        if (!checkPassword()) {
            signupInputPassword.setAnimation(animShake);
            signupInputPassword.startAnimation(animShake);
            vib.vibrate(120);
            return;
        }

        signupInputLayoutName.setErrorEnabled(false);
        signupInputLayoutEmail.setErrorEnabled(false);
        signupInputLayoutPassword.setErrorEnabled(false);

        //   Toast.makeText(getApplicationContext(),
        //    "You are logged in !!", Toast.LENGTH_SHORT).show();
    }

    private boolean checkName() {
        if (signupInputName.getText().toString().trim().isEmpty()) {
            signupInputLayoutName.setErrorEnabled(true);
            signupInputLayoutName.setError(getString(R.string.err_msg_name));
            signupInputName.setError(getString(R.string.err_msg_required));
            return false;
        }
        signupInputLayoutName.setErrorEnabled(false);
        return true;
    }

    private boolean checkEmail() {
        String email = signupInputEmail.getText().toString().trim();
        if (email.isEmpty() || !isValidEmail(email)) {

            signupInputLayoutEmail.setErrorEnabled(true);
            signupInputLayoutEmail.setError(getString(R.string.err_msg_email));
            signupInputEmail.setError(getString(R.string.err_msg_required));
            requestFocus(signupInputEmail);
            return false;
        }
        signupInputLayoutEmail.setErrorEnabled(false);
        return true;
    }

    private boolean checkPassword() {
        if (signupInputPassword.getText().toString().trim().isEmpty()) {

            signupInputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(signupInputPassword);
            return false;
        }
        signupInputLayoutPassword.setErrorEnabled(false);
        return true;
    }


    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}