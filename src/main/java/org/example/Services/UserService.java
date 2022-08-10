package org.example.Services;

import enums.Priority;
import org.example.Repository.UserRepository;
import org.example.TaskManager;
import org.example.Repository.TaskManagerRepository;
import org.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private static UserRepository myUser;


    public static void newUser(User user) {

        myUser.save(user);
    }

}
