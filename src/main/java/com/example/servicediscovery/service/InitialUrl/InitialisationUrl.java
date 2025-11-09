package com.example.servicediscovery.service.InitialUrl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InitialisationUrl {

    private static final Map<String, String> STATIC_MAP = new HashMap<>();

    static {
        STATIC_MAP.put("get", "http://user-app:8084/api/user/get/");
        STATIC_MAP.put("post", "http://user-app:8084/api/user/create");
        STATIC_MAP.put("update", "http://user-app:8084/api/user/update");
        STATIC_MAP.put("delete", "http://user-app:8084/api/user/delete/");
        STATIC_MAP.put("send", "http://notification-app:8085/sending/send");

    }

    public String prepareUrlForIntegration(String value) {
        String url = STATIC_MAP.get(value);
        return url;
    }
}
