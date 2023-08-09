package com.groupfour.foodbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserOrderDTO {

    private int order_no;
    private String user_id;
    private String user_name;

    private int orderTotPrice;

    private Date order_inputDate;

}
