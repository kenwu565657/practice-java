package com.practice.java.impl;

import com.practice.java.AuthInfo;
import com.practice.java.AuthLink;

import java.util.Date;

public class Level1AuthLink extends AuthLink {
    public Level1AuthLink(String levelUserId, String levelUserName) {
        super(levelUserId, levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uid, String orderId, Date authDate) {
        return getNext().doAuth(uid, orderId, authDate);
    }

}
