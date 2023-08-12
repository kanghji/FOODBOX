package com.groupfour.foodbox.mapper.admin;

import com.groupfour.foodbox.dto.AdminOrderDTO;
import com.groupfour.foodbox.dto.AdminOrderDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminOrderMapper {
    List<AdminOrderDTO> orderList();

    List<AdminOrderDetailDTO> orderDetail(int orderNo);
}
