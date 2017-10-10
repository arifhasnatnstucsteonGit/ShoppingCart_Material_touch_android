package com.mp1.dyao.dayao_marvin_mp2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.mp1.dyao.dayao_marvin_mp2.R;
import com.mp1.dyao.dayao_marvin_mp2.model.CartItemModel;

import java.util.ArrayList;

/**
 * Created by HC4U on 1/8/2017.
 */

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.EnterEnclosureHistoryAdapter> {



    private Context mContext;
    ArrayList<CartItemModel> duringEnclosure;


    public CartItemAdapter(ArrayList<CartItemModel> cartItemModels) {
        this.duringEnclosure = cartItemModels;
    }

    @Override
    public EnterEnclosureHistoryAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        EnterEnclosureHistoryAdapter viewHolder = new EnterEnclosureHistoryAdapter(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EnterEnclosureHistoryAdapter holder, final int position) {

        holder.name.setText(duringEnclosure.get(position).getName().toString());
        holder.price.setText("Price : "+ duringEnclosure.get(position).getPrice());
        holder.quantity.setText("Quantity : "+ duringEnclosure.get(position).getQuantity());



    }

    @Override
    public int getItemCount() {
        return duringEnclosure.size();
    }

    public class EnterEnclosureHistoryAdapter extends RecyclerView.ViewHolder {
        public TextView name, price, quantity;


        public EnterEnclosureHistoryAdapter(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name   );
            price = (TextView) itemView.findViewById(R.id.price);
            quantity = (TextView) itemView.findViewById(R.id.quantity);


        }
    }
}
