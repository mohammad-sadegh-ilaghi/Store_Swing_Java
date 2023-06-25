package org.example.Models.Behavior;

import org.example.Models.Entities.UserEntity;

import java.util.ArrayList;

public class UserBehavior {
    private ArrayList<UserEntity> users;
    public UserBehavior(ArrayList<UserEntity> users){
        this.users = users;
    }
    public boolean create(UserEntity user){
        users.add(user);
        return true;
    }
    public boolean login(UserEntity user){
        if (users.stream().filter(item ->item.getHashPassword() == user.getHashPassword() &&
                (item.getUserName()== user.getUserName())).count() >0){
            return true;
        }
        return false;
    }

}
