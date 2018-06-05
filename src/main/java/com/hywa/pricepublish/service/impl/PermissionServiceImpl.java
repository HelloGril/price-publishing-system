package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.dao.entity.Permission;
import com.hywa.pricepublish.dao.entity.PermissionExample;
import com.hywa.pricepublish.dao.mapper.PermissionMapper;
import com.hywa.pricepublish.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.selectByExample(null);
    }

    @Override
    public List<String> findPermissionByUserId(String id) {
        return null;
    }
}
