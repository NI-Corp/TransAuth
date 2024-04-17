package com.nicorp.transauth;

import java.util.HashMap;
import java.util.Map;

public enum Permission {
    EMAIL_PERMISSION("email_permission"),
    AVATAR_PERMISSION("avatar_permission"),
    // Добавьте другие разрешения здесь

    ;

    private final String value;

    Permission(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Permission fromValue(String value) {
        Map<String, Permission> permissionMap = new HashMap<>();
        for (Permission permission : Permission.values()) {
            permissionMap.put(permission.getValue(), permission);
        }
        return permissionMap.getOrDefault(value, null);
    }
}