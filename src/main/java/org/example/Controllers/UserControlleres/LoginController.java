package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.UserEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.UserViews.LoginView;
import org.example.Views.UserViews.RegisterView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;

public class LoginController implements CoreController {
    private LoginView view;
    private UserBehavior model;
    public LoginController() throws IOException {
        view = new LoginView();
        ActionListener loginAction = e-> loginClicked();
        view.actionListernerLogin(loginAction);
        model = UserBehavior.singelton();
    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
    public void loginClicked(){

        String  username =  view.getUsername().getText();
        String password = view.getPassword().getText();
        UserEntity user = new UserEntity(username, password);
        boolean result = model.login(user);
        if (username.trim().equals("") || password.trim().equals(""))
            validateUsernameAndPassword(username, password);
        else {
            if (result){
                JOptionPane.showMessageDialog(null, "user success logined");
                CoreMiddleWare middleWare = CoreMiddleWare.singelton();
                middleWare.loadFrame();
                clearForm();
            }
            else{
                view.setValidateUsername("password or username is invalid");
                view.setValidatePassword("password or username is invalid");
            }
        }
    }
    private void clearForm(){
        view.getUsername().setText("");
        view.getPassword().setText("");
    }
    private void validateUsernameAndPassword(String username, String password){
        if (username.trim().equals("")){
            view.setValidateUsername("the username is empty");
        }
        else {
            view.setValidateUsername("");
        }
        if (password.trim().equals("")){
            view.setValidatePassword("the password is empty");
        }
        else {
            view.setValidatePassword("");
        }
    }
}
