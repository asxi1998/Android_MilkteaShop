package com.example.thandroid_milkteabooking.Adapter;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thandroid_milkteabooking.HomeActivity;
import com.example.thandroid_milkteabooking.MainActivity;
import com.example.thandroid_milkteabooking.OrderFragment;
import com.example.thandroid_milkteabooking.SQLite;
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
    //SQLite sqLite=new SQLite(this.context,"milktea.sqlite",null,1);

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false);
        final MyViewHolder viewHolder = new MyViewHolder(itemview);
        viewHolder.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewHolder.number.setVisibility(View.VISIBLE);
                viewHolder.down.setVisibility(View.VISIBLE);

                if(parseInt(viewHolder.number.getText().toString()) == 1)
                {
                   // thêm dữ liệu
                    //sqLite.Insertcontacts(viewHolder.name.getText().toString(),viewHolder.image.getImageAlpha()+"",viewHolder.price.getText().toString(),viewHolder.number.getText().toString());
                }
                else {
                    if (parseInt(viewHolder.number.getText().toString()) > 1)
                    {
                        //sqLite.Upadatecontacts(viewHolder.name.getText().toString(),viewHolder.image.getImageAlpha()+"",viewHolder.price.getText().toString(),viewHolder.number.getText().toString());
                    }
                }
                int sl = Integer.parseInt(viewHolder.number.getText().toString() )+ 1;
                orderList.get(viewHolder.getAdapterPosition()).setSoluong(sl+"");
//                OrderFragment up = new OrderFragment();
//                up.Up(context);
                viewHolder.number.setText(orderList.get(viewHolder.getAdapterPosition()).getSoluong());
               if(sl>0)
               {
                   if(OrderFragment.giohang.size()>0)
                   {
                        boolean exist = false;
                        for(int i=0; i<OrderFragment.giohang.size();i++)
                        {
                            if(OrderFragment.giohang.get(i).getTen().equals(  orderList.get(viewHolder.getAdapterPosition()).getTen()))
                            {
                                Log.d("bbbb",OrderFragment.giohang.get(i).getTen()+"  "+ orderList.get(viewHolder.getAdapterPosition()).getTen());
                                OrderFragment.giohang.get(i).setSoluong(sl +"");
                                String mota= OrderFragment.giohang.get(i).getMota();

                                OrderFragment.giohang.get(i).setMota((100000*sl)+"");//Integer.parseInt(mota)
                                exist =true;  Log.d("ccc",OrderFragment.giohang.get(i).getMota()+OrderFragment.giohang.size());
                            }
                        }
                        if(!exist)
                        {
                            OrderFragment.giohang.add(new order(OrderFragment.orderList.get(viewHolder.getAdapterPosition()).getHinhanh(),viewHolder.name.getText().toString(),viewHolder.price.getText().toString()));
                        }

                   }
                   else
                   {
                       OrderFragment.giohang.add(new order(OrderFragment.orderList.get(viewHolder.getAdapterPosition()).getHinhanh(),viewHolder.name.getText().toString(),viewHolder.price.getText().toString()));

                   }Log.d("ccc",OrderFragment.giohang.size()+"");

               }
            }
        });

        viewHolder.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sl=0;
                if (parseInt(viewHolder.number.getText().toString()) > 0) {
                     sl = parseInt(orderList.get(viewHolder.getAdapterPosition()).getSoluong()) - 1;
                    orderList.get(viewHolder.getAdapterPosition()).setSoluong(sl + "");
                    viewHolder.number.setText(orderList.get(viewHolder.getAdapterPosition()).getSoluong());
                }
                if(parseInt(viewHolder.number.getText().toString()) == 0)
                {
                    viewHolder.number.setVisibility(View.GONE);
                    viewHolder.down.setVisibility(View.GONE);
                }
                if(sl>0)
                {
                    if(OrderFragment.giohang.size()>0)
                    {
                        boolean exist = false;
                        for(int i=0; i<OrderFragment.giohang.size();i++)
                        {
                            if(OrderFragment.giohang.get(i).getTen().equals(  orderList.get(viewHolder.getAdapterPosition()).getTen()))
                            {
                                Log.d("bbbb",OrderFragment.giohang.get(i).getTen()+"  "+ orderList.get(viewHolder.getAdapterPosition()).getTen());
                                OrderFragment.giohang.get(i).setSoluong(sl +"");
                                String mota= OrderFragment.giohang.get(i).getMota();

                                OrderFragment.giohang.get(i).setMota((100000*sl)+"");//Integer.parseInt(mota)
                                exist =true;  Log.d("ccc",OrderFragment.giohang.get(i).getMota()+OrderFragment.giohang.size());
                            }
                        }
                        if(!exist)
                        {
                            OrderFragment.giohang.add(new order(viewHolder.image.getDrawingCache(),viewHolder.name.getText().toString(),viewHolder.price.getText().toString()));
                        }

                    }
                    else
                    {
                        OrderFragment.giohang.add(new order(viewHolder.image.getDrawingCache(),viewHolder.name.getText().toString(),viewHolder.price.getText().toString()));

                    }Log.d("ccc",OrderFragment.giohang.size()+"");

                }
            }
        });



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image.setImageBitmap(orderList.get(position).getHinhanh());
        holder.name.setText(orderList.get(position).getTen());
        holder.price.setText(orderList.get(position).getMota());
        holder.number.setText(0+"");//orderList.get(position).getSoluong()
    }

    @Override
    public int getItemCount() {
        Log.d("dfs",orderList.size()+"dfd");
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
