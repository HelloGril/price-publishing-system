package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Override
    public List<String> findPermissionByUserId(String id) {
        return null;
    }
}
