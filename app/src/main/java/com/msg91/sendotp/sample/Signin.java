package com.msg91.sendotp.sample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signin extends AppCompatActivity {
TextView signin,fpass;
    Button login;
EditText uph,passok;
String a,b,c,d,e,f,g;
    private boolean loggedIn = false;
    SharedPreferences sharedPreferences,sh;
    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signin = findViewById(R.id.signin);
        login = findViewById(R.id.login);
        uph = findViewById(R.id.dw);
    check=findViewById(R.id.checkBox);
        passok=findViewById(R.id.passok);
        fpass=findViewById(R.id.fro);
        sh=getSharedPreferences("Official",MODE_PRIVATE);
        loggedIn=sh.getBoolean("ph",false);
        sharedPreferences=getSharedPreferences("phone",MODE_PRIVATE);
        if (loggedIn) {
            startActivity(new Intent(Signin.this,MainActivityhome.class));

        }
        fpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent h=new Intent(getApplicationContext(),MainActivityforgot.class);
                startActivity(h);
            }
        });

check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(b)
        {

            passok.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            check.setText("Hide");
        }
        else
        {

            passok.setTransformationMethod(PasswordTransformationMethod.getInstance());
            check.setText("Show");
        }
    }
});

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
            if (uph.getText().toString().isEmpty())
              {
                uph.setError("enter a valid phone number ");
            }
           else if (passok.getText().toString().isEmpty()){
               passok.setError("enter a valid phone  password");

            }
           else if (uph.getText().toString().length()<10){

                uph.setError("enter a valid phone number ");

            }


            else {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/RailwayRes/rrlogin.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                uph.getText().clear();
                              passok.getText().clear();


                                try {
                                    JSONArray jsonArray = new JSONArray(response);
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");
                                        a=json_obj.getString("phone");
                                        b=json_obj.getString("cid");
                                        c=json_obj.getString("name");
                                        d=json_obj.getString("emailid");
                                        e=json_obj.getString("address");
                                        f=json_obj.getString("gender");
                                        g=json_obj.getString("dob");


                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                if (response.contains("success")) {
                                     Toast.makeText(Signin.this,b,Toast.LENGTH_LONG).show();
                                    Intent in = new Intent(getApplicationContext(),MainActivityhome.class);
                                    SharedPreferences sh=getSharedPreferences("data",MODE_PRIVATE);
                                    SharedPreferences.Editor ee=sh.edit();
                                    ee.putString("phone",a);
                                    ee.putString("cid",b);
                                    ee.putString("name",c);
                                    ee.putString("email",d);
                                    ee.putString("address",e);
                                    ee.putString("gender",f);
                                    ee.putString("dob",g);
                                    ee.apply();

                                    startActivity(in);
                                }
                                else
                                {
                                    passok.setError("incorrect credentials");
                                }


                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                            }

                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("phone", uph.getText().toString());
                        params.put("passok",passok.getText().toString());

//returning parameter
                        return params;
                    }

                };

//Adding the string request to the queue
                RequestQueue requestQueue = Volley.newRequestQueue(Signin.this);
                requestQueue.add(stringRequest);
            }

        }


        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

            }
        });
    }


}
