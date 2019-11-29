package com.example.thandroid_milkteabooking.model;

import android.widget.ImageView;
import android.widget.TextView;

public class OrderListView {

    int imageView;
    String title;
    String price;

    public OrderListView(int imageView, String title, String price) {
        this.imageView = imageView;
        this.title = title;
        this.price = price;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
