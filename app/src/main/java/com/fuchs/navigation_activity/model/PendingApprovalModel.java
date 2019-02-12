package com.fuchs.navigation_activity.model;

public class PendingApprovalModel {
    String order_num;
    String order_date;
    String request_date;
    String sold_to_party;
    String ship_to_party;
    String value;


    public PendingApprovalModel(String order_num, String order_date, String request_date, String sold_to_party, String ship_to_party, String value) {
        this.order_num = order_num;
        this.order_date = order_date;
        this.request_date = request_date;
        this.sold_to_party = sold_to_party;
        this.ship_to_party = ship_to_party;
        this.value = value;
    }

    public String getOrder_num() {
        return order_num;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getRequest_date() {
        return request_date;
    }

    public String getSold_to_party() {
        return sold_to_party;
    }

    public String getShip_to_party() {
        return ship_to_party;
    }

    public String getValue() {
        return value;
    }
}
