package com.example.thandroid_milkteabooking.model;

public class HomeListView {
    int ImageHomeListView;
    String Title;
    String Direction;

    public HomeListView(int imageHomeListView, String title, String direction) {
        ImageHomeListView = imageHomeListView;
        Title = title;
        Direction = direction;
    }

    public int getImageHomeListView() {
        return ImageHomeListView;
    }

    public void setImageHomeListView(int imageHomeListView) {
        ImageHomeListView = imageHomeListView;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        Direction = direction;
    }
}
