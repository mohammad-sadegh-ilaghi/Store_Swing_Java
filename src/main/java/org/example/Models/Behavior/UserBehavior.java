package org.example.Models.Behavior;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Configure.UserConfigure;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.UserEntity;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class UserBehavior implements Serializable{
    private String filePath = "src/main/java/org/example/Models/Files/users.ser";
    private static UserBehavior instance;
    private static final Logger logger = LogManager.getLogger(UserBehavior.class);

    private ArrayList<UserEntity> users;
    public static UserBehavior singelton() throws IOException {
        if (instance == null)
            instance = new UserBehavior();
        return instance;
    }
    private UserBehavior() throws IOException {
        users = readFile();
        if (users==null){
            users = new ArrayList<>();
            logger.fatal("file can not read and create");
        }

    }
    public boolean create(UserEntity user)  {
        users.add(user);
        try {
            if (write("user created account: ", user) && !checkDouplicateUser(user)){
                UserConfigure userConfigure = UserConfigure.singlton();
                userConfigure.login(user);
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        users.removeIf(item -> item.getUserName() == user.getUserName() && item.getEmail() == user.getEmail());
        return false;
    }
    public boolean checkDouplicateUser(UserEntity user){
        return users.stream().filter(item ->
                                item.getUserName().trim().toUpperCase().equals(user.getUserName().toUpperCase())
                                || item.getEmail().trim().toUpperCase().equals(user.getEmail().toUpperCase())
                                || item.getNumberPhone().trim().equals(user.getNumberPhone())).count() > 0;
    }
    public boolean edit(UserEntity user) throws NoSuchAlgorithmException {
        int index = 0;
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().trim().toUpperCase().equals(user.getEmail().toUpperCase().trim()))
                index = i;
        }
        user.getCardBank().setInventory(users.get(index).getCardBank().getInventory());
        users.set(index, user);
        boolean result = false;
        try {
            result = write("edit user", user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!result)
            return false;
        return true;
    }

    public boolean login(UserEntity user){
        logger.info("user with username :" + user.getUserName() + "try to login");
        if (users.stream().filter(item ->item.getHashPassword().equals(user.getHashPassword()) &&
                (item.getUserName().equals(user.getUserName()))).count() >0){
            UserConfigure userConfigure = UserConfigure.singlton();
            userConfigure.login(users.stream().filter(item ->item.getHashPassword().equals(user.getHashPassword()) &&
                    (item.getUserName().equals(user.getUserName()))).toList().get(0));
            return true;
        }
        return false;
    }
    private ArrayList<UserEntity> readFile() throws IOException {
        try(FileInputStream usersFile = new FileInputStream(filePath)){
            ObjectInputStream in = new ObjectInputStream(usersFile);

            ArrayList<UserEntity> entities=(ArrayList<UserEntity>) in.readObject();
            logger.info("user file readed ");
            return entities;
        } catch (IOException e) {
            File file = new File(filePath);
            logger.warn(e.getMessage());

            file.createNewFile();
            logger.info("user file created ");
            return new ArrayList<>();
        } catch (Exception e) {
            logger.fatal(e.getMessage());
        }
        return null;
    }
    private boolean write(String log, UserEntity user) throws IOException {
        try (FileOutputStream fileUser = new FileOutputStream(filePath)){
            ObjectOutputStream out = new ObjectOutputStream(fileUser);
            out.writeObject(users);
            logger.info(log + user.toString());
            return true;
        } catch (FileNotFoundException e) {
            File file = new File(filePath);
            file.createNewFile();
            write(log, user);
            logger.fatal("can not find file of user");
        } catch (Exception e) {
            logger.fatal(e.getMessage());
        }
        return false;
    }
    public boolean removeDataFromFile(){
        try (FileOutputStream fileUser = new FileOutputStream(filePath)){
            ObjectOutputStream out = new ObjectOutputStream(fileUser);
            users = new ArrayList<>();
            out.writeObject(users);
            logger.info("file removed data.");
            return true;
        } catch (FileNotFoundException e) {
            logger.fatal("can not find file of user");
        } catch (Exception e) {
            logger.fatal(e.getMessage());
        }
        return false;
    }
}
