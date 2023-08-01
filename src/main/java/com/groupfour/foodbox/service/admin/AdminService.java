package com.groupfour.foodbox.service.admin;

import com.groupfour.foodbox.domain.AdminDTO;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    boolean adminLogin(AdminDTO dto,HttpServletRequest req);
}
