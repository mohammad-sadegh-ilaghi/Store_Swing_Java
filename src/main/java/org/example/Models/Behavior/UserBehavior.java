package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Entities.UserEntity;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Objects;

public class UserBehavior {
    private static final Logger logger = LogManager.getLogger(AirConditionerBehavior.class);

    private ArrayList<UserEntity> users;
    public UserBehavior() throws IOException {
        users = readFile();
        if (users==null)
            users = new ArrayList<>();
            logger.fatal("file can not read and create");
    }
    public boolean create(UserEntity user){
        if (write("user created account: ", user)){
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean edit(UserEntity user) throws NoSuchAlgorithmException {
        UserEntity userMain = users.stream()
                .filter(item -> item.getEmail() == item.getEmail())
                .toList()
                .get(0);
        userMain =user;
        userMain.setPassword(user.getPassword());
        boolean result = write("edit user", user);
        if (!result)
            return false;

        return true;
    }
    public boolean login(UserEntity user){
        if (users.stream().filter(item ->item.getHashPassword() == user.getHashPassword() &&
                (item.getUserName()== user.getUserName())).count() >0){
            return true;
        }
        return false;
    }
    private ArrayList<UserEntity> readFile() throws IOException {
        try(FileInputStream usersFile = new FileInputStream("../../Files/users.txt")){
            ObjectInputStream in = new ObjectInputStream(usersFile);

            ArrayList<UserEntity> entities=(ArrayList<UserEntity>) in.readObject();
            logger.info("user file readed ");
            return entities;
        } catch (FileNotFoundException e) {
            File file = new File("../../Files/users.txt");
            file.createNewFile();
            logger.info("user file created ");
            return new ArrayList<>();
        } catch (Exception e) {
            logger.fatal(e);
        }
        return null;
    }
    private boolean write(String log, UserEntity user){
        try (FileOutputStream fileUser = new FileOutputStream("../../Files/users.txt")){
            ObjectOutputStream out = new ObjectOutputStream(fileUser);
            out.writeObject(users);
            logger.info(log + user.toString());
            return true;
        } catch (FileNotFoundException e) {
            logger.fatal("can not find file of user");
        } catch (Exception e) {
            logger.fatal(e.toString());
        }
        return false;
    }
}
