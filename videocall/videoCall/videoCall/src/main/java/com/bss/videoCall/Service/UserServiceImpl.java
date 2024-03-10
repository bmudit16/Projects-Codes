package com.bss.videoCall.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.bss.videoCall.User.User;

@Service
public class UserServiceImpl {

    private static final List<User> Users_List = new ArrayList<>();

    public void register(User user) {
        user.setStatus("online");
        Users_List.add(user);
    }

    public User login(User user) {
        int userIndex = -1;
        User userObj = null;
        ;
        for (User u : Users_List) {
            userIndex++;
            if (u.getEmail().equals(user.getEmail()))
                break;
        }
        if (userIndex == -1)
            throw new RuntimeException("User not found");
        if (!Users_List.get(userIndex).getPassword().equals(user.getPassword()))
            throw new RuntimeException("Password Incorrect");
        userObj = Users_List.get(userIndex);
        userObj.setStatus("onLine");
        return userObj;
    }

    public void logout(String email) {
        var userIndex = IntStream.range(0, Users_List.size())
                .filter(i -> Users_List.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"));
        Users_List.get(userIndex).setStatus("offLine");
    }

    public List<User> findAll() {
        return Users_List;
    }
}
