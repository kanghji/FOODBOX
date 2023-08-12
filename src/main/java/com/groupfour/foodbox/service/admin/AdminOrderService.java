package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.dto.AdminOrderDTO;
import com.groupfour.foodbox.dto.AdminOrderDetailDTO;

import java.util.List;

public interface AdminOrderService {

    List<AdminOrderDTO> orderList();

    List<AdminOrderDetailDTO> orderDetail(int orderNo);
}
