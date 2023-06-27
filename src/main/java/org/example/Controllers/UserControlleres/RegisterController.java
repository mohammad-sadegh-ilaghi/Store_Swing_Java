package org.example.Controllers.UserControlleres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.CardEntity;
import org.example.Models.Entities.UserEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.UserViews.RegisterView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class RegisterController implements CoreController {
    private static final Logger logger = LogManager.getLogger(RegisterController.class);

    private UserBehavior model;
    private RegisterView view;
    public RegisterController() throws IOException {
        model = UserBehavior.singelton();
        view = new RegisterView();
        ActionListener actionListener = e ->register();
        view.setRegisterButton(actionListener);
    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
    public void register(){
        UserEntity user = getFeilds();
        if (user != null){
            boolean result = validateUser(user);
            if (result){
                result = model.create(user);
                if (!result){
                    view.setEmailValidate("Username or Number phone or  Email is signuped!!!");
                    view.setUsernameValidate("Username or Number phone or  Email is signuped!!!");
                    view.setNumberValidate("Username or Number phone or  Email is signuped!!!");
                }else {
                    CoreMiddleWare middleWare = CoreMiddleWare.singelton();
                    middleWare.loadFrame();
                    view.clearTextFeilds();
                }
            }
        }
    }
    public UserEntity getFeilds(){
        String username = view.getUsername().getText();
        String email = view.getEmail().getText();
        String password = view.getPhoneNumber().getText();
        String phoneNumber = view.getPhoneNumber().getText();
        int idCard = 0;
        try {
             idCard = Integer.parseInt(view.getIdCard().getText());
        }catch (NumberFormatException e){
            view.setIdCardValidate("the idCard must by number");
        }
        String bankName = view.getBankName().getText();
        int inentory = 0;
        try {
            inentory = Integer.parseInt(view.getInventory().getText());
        }
        catch (NumberFormatException e){
            view.setInventoryValidate("the inventory must by number");
        }

        CardEntity card = new CardEntity(idCard, bankName, inentory);
        UserEntity user = null;
        try {
             user = new UserEntity(username, phoneNumber, password, email, card);
        } catch (NoSuchAlgorithmException e) {
            logger.fatal("can not hasing code for user :" + user);
            view.setPasswordValidate("Have some problem try again");
            return null;
        }
        return user;
    }

    private boolean isValidEmail(String email) {
        // regular expression to validate email
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
    private boolean validateUser(UserEntity user){
        boolean result = true;
        if (user.getUserName().trim().equals("")){
             view.setUsernameValidate("user name must by entered");
             result = false;
        }
        else
            view.setUsernameValidate("");
        if (user.getEmail().trim().equals("")){
            view.setEmailValidate("Email must by entered");
            result = false;
        }
        else
            view.setEmailValidate("");

        if (user.getPassword().trim().equals("")){
            view.setPasswordValidate("Password must be entered");
            result = false;
        }else
            view.setPasswordValidate("");
        if (user.getCardBank().getBank().trim().equals("")){
            view.setBankNameValidate("Bank Name must be entered");
            result = false;
        }else
            view.setBankNameValidate("");
        return result;
    }

}
