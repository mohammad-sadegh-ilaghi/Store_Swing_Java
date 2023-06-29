package org.example.Configure;

import org.example.Models.Entities.UserEntity;

public class UserConfigure {
    private static UserConfigure instance;
    private UserEntity user;
    private UserConfigure(){

    }
    public void login(UserEntity user){
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }
    public boolean isLogin(){
        return user != null;
    }

    public static UserConfigure singlton(){
        if (instance == null)
            instance = new UserConfigure();
        return instance;
    }
    public boolean logOut(){
        user = null;
        return true;
    }
}
