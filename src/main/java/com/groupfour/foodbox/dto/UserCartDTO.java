package com.groupfour.foodbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserCartDTO {

    private String user_id;
    private String user_name;

    private int prod_code;
    private String prod_name;
    private String prod_thumbnail;
    private int prod_price;
    private int prod_qty;

    private Date order_inputDate;
}
