package com.ics.services;

import com.ics.dtos.SuperVisorRequest;
import com.ics.models.AdminUser;

public interface AdminUserService {
    AdminUser save(AdminUser adminUser);
}
