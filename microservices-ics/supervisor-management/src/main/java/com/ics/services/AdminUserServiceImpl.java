package com.ics.services;

import com.ics.dtos.SuperVisorRequest;
import com.ics.models.AdminUser;
import com.ics.repositorys.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService{
    @Autowired
    private AdminUserRepository adminUserRepository;
    @Override
    public AdminUser save(AdminUser adminUser) {

       return adminUserRepository.save(adminUser);
    }
}
