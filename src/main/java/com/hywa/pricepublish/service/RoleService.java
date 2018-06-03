package com.hywa.pricepublish.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {
    List<String> findRoleByUid(String id);
}
