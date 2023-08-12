package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.dto.AdminOrderDTO;
import com.groupfour.foodbox.dto.AdminOrderDetailDTO;
import com.groupfour.foodbox.dto.UserOrderDetailDTO;
import com.groupfour.foodbox.mapper.admin.AdminOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOrderServiceImpl implements AdminOrderService{

    @Autowired
    AdminOrderMapper adminOrderMapper;

    @Override
    public List<AdminOrderDTO> orderList() {
        List<AdminOrderDTO> orderList = adminOrderMapper.orderList();

        return orderList;
    }

    @Override
    public List<AdminOrderDetailDTO> orderDetail(int orderNo) {
        List<AdminOrderDetailDTO> orderDetail = adminOrderMapper.orderDetail(orderNo);

        for(AdminOrderDetailDTO dto : orderDetail) {
            dto.setTotPrice(dto.getTotPrice());
        }

        return orderDetail;
    }
}
