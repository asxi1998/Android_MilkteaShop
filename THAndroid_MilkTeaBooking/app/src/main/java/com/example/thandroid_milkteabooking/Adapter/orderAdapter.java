package com.example.thandroid_milkteabooking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thandroid_milkteabooking.model.order;
import com.example.thandroid_milkteabooking.R;

import java.util.List;

import static java.lang.Integer.parseInt;

public class orderAdapter extends RecyclerView.Adapter<orderAdapter.MyViewHolder> {
    private List<order> orderList;
    private Context context;

    public orderAdapter(List<order> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(itemview);
        viewHolder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.number.setVisibility(View.VISIBLE);

                int sl = parseInt(orderList.get(viewHolder.getAdapterPosition()).getSoluong()) + 1;
                orderList.get(viewHolder.getAdapterPosition()).setSoluong(sl+"");
//                OrderFragment up = new OrderFragment();
//                up.Up(context);
                viewHolder.number.setText(orderList.get(viewHolder.getAdapterPosition()).getSoluong());
                Toast.makeText(context,"up "+orderList.get(viewHolder.getAdapterPosition()).getSoluong(),Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (parseInt(viewHolder.number.getText().toString()) > 0) {
                    int sl = parseInt(orderList.get(viewHolder.getAdapterPosition()).getSoluong()) - 1;
                    orderList.get(viewHolder.getAdapterPosition()).setSoluong(sl + "");
                    viewHolder.number.setText(orderList.get(viewHolder.getAdapterPosition()).getSoluong());
                    Toast.makeText(context, "down " + orderList.get(viewHolder.getAdapterPosition()).getSoluong(), Toast.LENGTH_LONG).show();
                }
                if(parseInt(viewHolder.number.getText().toString()) == 0)
                {
                    viewHolder.number.setVisibility(View.GONE);
                }
            }
        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image.setImageResource(orderList.get(position).getHinhanh());
        holder.name.setText(orderList.get(position).getTen());
        holder.price.setText(orderList.get(position).getMota());
        holder.number.setText(orderList.get(position).getSoluong());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,price,number;
        Button up,down;
        public MyViewHolder(@NonNull View view) {
            super(view);
            image = view.findViewById(R.id.img_item);
            name = view.findViewById(R.id.name_item);
            price= view.findViewById(R.id.price_item);
            number= view.findViewById(R.id.number_item);
            down= view.findViewById(R.id.down_item);
            up= view.findViewById(R.id.up_item);
        }


    }
}
