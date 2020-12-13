package com.finalproject.service;

import com.finalproject.entity.User;
import com.finalproject.enums.SecurityAccess;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SecurityCheck {
    private static final Map<SecurityAccess, List<String>> securityPages = new HashMap<>();

    static {
        securityPages.put(SecurityAccess.ADMIN, Arrays.asList("/account_info", "/create_account", "/admin_account_info"));
        securityPages.put(SecurityAccess.USER, Arrays.asList("/account_info", "/create_account", "/manage_accounts"));
    }

    public static boolean isSecurePage(String page) {
        return securityPages.values().stream()
                .anyMatch(list -> list.stream()
                        .anyMatch(pageValue -> pageValue.equals(page)));
    }

    public static boolean hasPermission(String page, SecurityAccess securityAccess) {
        return securityPages.getOrDefault(securityAccess, Collections.EMPTY_LIST)
                .stream()
                .anyMatch(securePage -> securePage.equals(page));
    }

    public static boolean hasPermission(HttpServletRequest request, SecurityAccess role) {
        User currentUser = getCurrentUser(request);
        return currentUser != null && currentUser.getSecurityAccess().equals(role);
    }

    public static User getCurrentUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }
}
