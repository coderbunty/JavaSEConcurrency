package com.app1.tests;

import com.app1.dao.UserDAO;
import com.app1.runnables.UserProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestExecutorService {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        userDAO.removeAllUsers();
        List<String> users = getUsersFromFile("/home/dell/Courses_Learning/Ex_Files_Java_EE_Concurrency/ExerciseFiles/" +
                "Chapter3/03_07/begin/javaseconcurrency/new_users.txt");
        //ExecutorService execService = Executors.newSingleThreadExecutor();
        //ExecutorService execService = Executors.newCachedThreadPool();
        ExecutorService execService = Executors.newFixedThreadPool(5);

        for (String user : users) {
            Future<Integer> future = execService.submit(new UserProcessor(user, userDAO));
            try {
                System.out.println("Result of the operation is " + future.get());
            } catch (InterruptedException e) {
                Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, e);
            } catch (ExecutionException e) {
                Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        execService.shutdown();
        System.out.println("Main thread execution finishes.");
    }

    private static List<String> getUsersFromFile(String file) {
        List<String> users = new ArrayList<String>();
        File userFile = new File(file);
        Scanner scan = null;
        try {
            scan = new Scanner(userFile);
            while (scan.hasNextLine()) {
                users.add(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(TestExecutorService.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            scan.close();
        }

        return users;
    }
}
