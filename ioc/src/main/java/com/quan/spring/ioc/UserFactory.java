package com.quan.spring.ioc;

import com.quan.spring.ioc.bean.User;

public class UserFactory {
    public static User get() {
        return new User();
    }
}
