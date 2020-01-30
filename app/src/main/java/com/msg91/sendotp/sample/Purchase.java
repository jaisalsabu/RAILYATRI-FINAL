package com.msg91.sendotp.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Purchase extends AppCompatActivity {
TextView pname,pname2,pname3,pname0,pname20,pname30;
Intent i;
Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);
         pname=findViewById(R.id.pname);
         bt=findViewById(R.id.p_btn);
        pname2=findViewById(R.id.pname2);
        pname3=findViewById(R.id.pname3);
        pname0=findViewById(R.id.pname0);
        pname20=findViewById(R.id.pname20);
        pname30=findViewById(R.id.pname30);
         i=getIntent();
        pname2.setText(i.getStringExtra("tna"));
        pname3.setText(i.getStringExtra("tno"));
        pname.setText(i.getStringExtra("tso"));
        pname20.setText(i.getStringExtra("tde"));
        pname30.setText(i.getStringExtra("tdt"));
        pname0.setText(i.getStringExtra("tcst"));

bt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent j=new Intent(getApplicationContext(),Purchaseconfirm.class);
        j.putExtra("tno",pname3.getText().toString());
        j.putExtra("tna",pname2.getText().toString());
        j.putExtra("tso",pname.getText().toString());
        j.putExtra("tde",pname20.getText().toString());
        j.putExtra("tdt",pname30.getText().toString());
        j.putExtra("tcst",pname0.getText().toString());
        startActivity(j);
    }
});
    }
}
