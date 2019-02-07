package com.fuchs.navigation_activity.model;

public class OrderItemModel {
    String date;
    String heading;
    String count;

    public OrderItemModel(String date, String heading, String count) {
        this.date = date;
        this.heading = heading;
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public String getHeading() {
        return heading;
    }

    public String getCount() {
        return count;
    }
}
