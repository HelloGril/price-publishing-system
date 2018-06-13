package com.hywa.pricepublish.common.exception;

import com.hywa.pricepublish.common.Sex;
import com.hywa.pricepublish.dao.entity.User;

public class Test {
    public static void main(String[] args) throws SexInputException {
        User user = new User();
        user.setJob(null);
        System.out.println(user);

        System.out.println(Sex.getIndex("女"));
    }
}
