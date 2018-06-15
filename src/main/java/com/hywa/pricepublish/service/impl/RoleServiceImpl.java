package com.hywa.pricepublish.service.impl;

import com.hywa.pricepublish.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Override
    public List<String> findRoleByUid(String id) {
        return null;
    }
}
