package com.app.runnables;

import com.app.beans.User;
import com.app.dao.UserDAO;

import java.util.StringTokenizer;
import java.util.concurrent.Callable;

public class UserProcessor implements Callable<Integer> {

    private String userInfo;
    private UserDAO userDao;

    public UserProcessor(String userInfo, UserDAO userDao) {
        this.userInfo = userInfo;
        this.userDao = userDao;
    }

    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " processing record for " + userInfo);
        int rows = 0;
        StringTokenizer tokenizer = new StringTokenizer(userInfo, ",");
        User user = new User();
        user.setEmail(tokenizer.nextToken());
        user.setName(tokenizer.nextToken());
        user.setId(Integer.parseInt(tokenizer.nextToken()));
        rows = userDao.saveUser(user);
        return rows;
    }
}
