package com.groupfour.foodbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOrderDetailDTO {

    private int order_detail_no;
    private int order_no;

    private String user_id;
    private String user_name;

    private int prod_code;
    private String prod_name;
    private String prod_thumbnail;
    private int prod_price;
    private int prod_qty;
    private int order_qty;

    private int totPrice;

    private Date order_inputDate;

    public void setTotPrice(int totPrice) {
        this.totPrice = prod_price * order_qty;
    }

}
