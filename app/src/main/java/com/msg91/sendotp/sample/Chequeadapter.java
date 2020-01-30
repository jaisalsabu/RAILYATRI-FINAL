package com.msg91.sendotp.sample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Chequeadapter extends RecyclerView.Adapter<Chequeadapter.ProductViewHolder> {
    Intent i;
    private Context mCtx;
    private List<Cheque> productList;

    public Chequeadapter(Context mCtx, List<Cheque> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.recycler_c, null);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
      final   Cheque cheque;   cheque = productList.get(position);

        //loading the image
holder.tno.setText(cheque.getTrainno());
holder.tna.setText(cheque.getTrainname());
holder.tso.setText(cheque.getTrainsource());
holder.tde.setText(cheque.getTraindestination());
holder.tdt.setText(cheque.getTraindate());
holder.tcst.setText(cheque.getTraincost());

holder.purchase.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Intent i=new Intent(mCtx,Purchase.class);

        i.putExtra("tno", cheque.getTrainno());
        i.putExtra("tna",cheque.getTrainname());
        i.putExtra("tso",cheque.getTrainsource());
        i.putExtra("tde",cheque.getTraindestination());
        i.putExtra("tdt",cheque.getTraindate());
        i.putExtra("tcst",cheque.getTraincost());
        mCtx.startActivity(i);
    }
});

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {



        TextView tno,tna,tso,tde,tdt,tcst;
        Button purchase;
        public ProductViewHolder(View itemView) {
            super(itemView);

            tno=itemView.findViewById(R.id.t_discription1);
            tna=itemView.findViewById(R.id.pph2);
            tso= itemView.findViewById(R.id.pph1);
            tde= itemView.findViewById(R.id.t_discription10);
            tdt= itemView.findViewById(R.id.pph20);
            tcst=itemView.findViewById(R.id.pph10);
            purchase=itemView.findViewById(R.id.purchase);

        }

    }
    public void filterList(ArrayList<Cheque> filteredList) {
        productList = filteredList;
        notifyDataSetChanged();
    }



}