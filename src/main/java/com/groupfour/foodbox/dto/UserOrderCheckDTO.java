package com.groupfour.foodbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserOrderCheckDTO {

    private String user_id;
    private String user_name;
    private String receiver_name;
    private String receiver_tel;
    private String user_zipcode;
    private String user_roaddr;
    private String user_detailaddr;

    private int cart_no;
    private int prod_code;
    private String prod_name;
    private String prod_thumbnail;
    private int prod_price;
    private int prod_qty;
    private int order_qty;

    private int totPrice;

    private Date order_inputDate;

    private List<UserOrderCheckDTO> orderList;
    private UserOrderCheckDTO userOrderCheckDTO;

    public void setTotPrice(int totPrice) {
        this.totPrice = prod_price * order_qty;
    }

}
