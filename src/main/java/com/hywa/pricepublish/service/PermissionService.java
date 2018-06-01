package com.hywa.pricepublish.service;

import java.util.List;

public interface PermissionService {
    List<String> findPermissionByUserId(String id);
}
