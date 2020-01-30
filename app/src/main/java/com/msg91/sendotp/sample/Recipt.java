package com.msg91.sendotp.sample;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Recipt extends AppCompatActivity {
Intent j;
String a,b,c,d,e,f,g,h,ii,jj,kk,ll;

TextView rtrackid,rname,rphone,remail,raddress,rnos,rtrainno,rtrainname,rsource,rdestination,rdeptdate,rcost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipt);
        rtrackid = findViewById(R.id.rtrackid);
        rname = findViewById(R.id.rname);
        rphone = findViewById(R.id.rphone);
        remail=findViewById(R.id.remail);
        raddress=findViewById(R.id.raddress);
        rnos=findViewById(R.id.rnos);
        rtrainno=findViewById(R.id.rtrainno);
        rtrainname=findViewById(R.id.rtrainname);
        rsource=findViewById(R.id.rsource);
        rdestination=findViewById(R.id.rdestination);
        rdeptdate=findViewById(R.id.rdeptdate);
        rcost=findViewById(R.id.rcost);
        j=getIntent();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://hastalavistaresto.000webhostapp.com/RailwayRes/recipt.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject json_obj = jsonArray.getJSONObject(i);


                                a=json_obj.getString("trackid");
                                b=json_obj.getString("name");
                                c=json_obj.getString("phone");
                                d=json_obj.getString("email");
                                e=json_obj.getString("address");
                                f=json_obj.getString("nos");
                                g=json_obj.getString("trainno");
                                h=json_obj.getString("trainname");
                                ii=json_obj.getString("source");
                                jj=json_obj.getString("destination");
                                kk=json_obj.getString("deptdate");
                                ll=json_obj.getString("cost");
                                rtrackid.setText("trackid:"+a);
                                rname.setText("name:"+b);
                                rphone.setText("phone:"+c);
                                remail.setText("email"+d);
                                raddress.setText("address:"+e);
                                rnos.setText("nos:"+f);
                                rtrainno.setText("trainno:"+g);
                                rtrainname.setText("trainname:"+h);
                               rsource.setText("TO:"+ii);
                               rdestination.setText("FROM:"+jj);
                               rdeptdate.setText("D O T:"+kk);
                               rcost.setText("Price:"+ll);

                            }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //   Toast.makeText(Signin.this, "success", Toast.LENGTH_LONG).show();
if(response.contains("success"))
{
    new Handler().postDelayed(new Runnable() {


        @Override
        public void run() {
            // This method will be executed once the timer is over
            Intent i = new Intent(Recipt.this, MainActivityhome.class);
            startActivity(i);
            finish();
        }
    }, 10000);
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
//Adding parameters to request

                params.put("tid", j.getStringExtra("phone"));
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                return params;
            }

        };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
        sms();
    }
public void sms()
{
    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://androidprojectstechsays.000webhostapp.com/Flower_maegument_system/c_copy1.php",
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
//If we are getting success from server
                    Toast.makeText(Recipt.this, response, Toast.LENGTH_LONG).show();
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject json_obj = jsonArray.getJSONObject(i);

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
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
//Adding parameters to request

           /* params.put("tid",rid.getText().toString());
            params.put("tname",rname.getText().toString());
            params.put("tph",rph.getText().toString());
            params.put("tadd",radd.getText().toString());
            params.put("tnos",rnos.getText().toString());
            params.put("tppraice",rprice.getText().toString());
            params.put("tpname",rpname.getText().toString());
            params.put("tpdetails",rpdetails.getText().toString()); */


            return params;
        }

    };


//Adding the string request to the queue
    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
    requestQueue.add(stringRequest);
}


}








