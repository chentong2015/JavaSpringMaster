package com.aspect.main;

import com.aspect.main.model.SecuredClass;

public class MainAspect {

    public static void main(String[] args) {
        SecuredClass service = new SecuredClass();
        service.unlockedMethod();
        service.lockedMethod();
    }
}
