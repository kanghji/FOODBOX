package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.domain.PageDTO;
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
    public int orderListCount() {
        int orderListCount = adminOrderMapper.orderListCount();
        return orderListCount;
    }

    @Override
    public List<AdminOrderDTO> orderList(PageDTO pageDTO) {
        List<AdminOrderDTO> orderList = adminOrderMapper.orderList(pageDTO);

        return orderList;
    }

    @Override
    public int orderDetailCount(int orderNo) {
        int orderDetailCount = adminOrderMapper.orderDetailCount(orderNo);
        return orderDetailCount;
    }

    @Override
    public List<AdminOrderDetailDTO> orderDetail(int orderNo, PageDTO pageDTO) {
        List<AdminOrderDetailDTO> orderDetail = adminOrderMapper.orderDetail(orderNo, pageDTO);

        for(AdminOrderDetailDTO dto : orderDetail) {
            dto.setTotPrice(dto.getTotPrice());
        }

        return orderDetail;
    }
}
