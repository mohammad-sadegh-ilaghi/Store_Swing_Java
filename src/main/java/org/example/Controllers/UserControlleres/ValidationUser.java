package org.example.Controllers.UserControlleres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Models.Entities.CardEntity;
import org.example.Models.Entities.UserEntity;
import org.example.Rules.RulesUser;
import org.example.Views.UserViews.RegisterEditView;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class ValidationUser {
    private static final Logger logger = LogManager.getLogger(ValidationUser.class);

    public static UserEntity getFeilds(RegisterEditView view){
        String username = view.getUsername().getText();
        String email = view.getEmail().getText();
        String password = view.getPassword().getText();
        String phoneNumber = view.getPhoneNumber().getText();
        RulesUser ruleUser = RulesUser.valueOf(view.getRules().getSelectedItem().toString());
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
            user = new UserEntity(username, phoneNumber, password, email, card, ruleUser);
        } catch (NoSuchAlgorithmException e) {
            logger.fatal("can not hasing code for user :" + user);
            view.setPasswordValidate("Have some problem try again");
            return null;
        }
        return user;
    }

    public static boolean isValidEmail(String email) {
        // regular expression to validate email
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
    public static boolean validateUser(UserEntity user, RegisterEditView view){
        boolean result = true;
        if (user.getUserName().trim().equals("")){
            view.setUsernameValidate("user name must by entered");
            result = false;
        }
        else
            view.setUsernameValidate("");
        if (user.getEmail().trim().equals("") ){
            view.setEmailValidate("Email must by entered");
            result = false;
        }
        else
            view.setEmailValidate("");
        if (!isValidEmail(user.getEmail())){
            result = false;
            view.setEmailValidate("email pattern is not true");
        }
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
