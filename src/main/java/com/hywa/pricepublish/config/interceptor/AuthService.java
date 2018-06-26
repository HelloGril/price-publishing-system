package com.hywa.pricepublish.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AuthService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public List<Map<String, String>> getPermission(String userId) {
//        String s = stringRedisTemplate.opsForValue().get(userId + "permissions");
        List<Map<String, String>> maps = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("priName", "采集模块");
        maps.add(map);
        return maps;
    }
}
