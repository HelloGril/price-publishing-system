package com.hywa.pricepublish.service;

import com.hywa.pricepublish.dao.entity.Permission;

import java.util.List;

public interface PermissionService {
    List<String> findPermissionByUserId(String id);

    List<Permission> findAll();
}
