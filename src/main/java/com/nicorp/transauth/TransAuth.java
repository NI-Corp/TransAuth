package com.nicorp.transauth;

public class TransAuth {

    private static String appId, secretKey;
    private static Permission[] permissions;

    public static void init(String appId, String secretKey, Permission[] permissions) throws Exception {
        TransAuth.appId = appId;
        TransAuth.secretKey = secretKey;
        TransAuth.permissions = permissions;

        if (TransAuth.checkPossibility()) {
            return;
        } else {
            // Throw new exception
            throw new Exception("100: Library authorization failed");
        }
    }

    public static boolean checkPossibility() {
        // TODO: проверить возможность использования сервиса
//        if (appId == null || secretKey == null) {
//            return false;
//        }
        return false;
    }

    public static String getAppId() {
        return appId;
    }

    public static String getSecretKey() {
        return secretKey;
    }

    public static Permission[] getPermissions() {
        return permissions;
    }
}
