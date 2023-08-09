package com.groupfour.foodbox.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserOrderDTO {

    private int order_no;
    private OrderStatus order_status;
    private String user_id;
    private String user_name;

    private int orderTotPrice;

    private LocalDateTime order_inputDate;

}
