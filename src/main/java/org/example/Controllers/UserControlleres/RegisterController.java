package org.example.Controllers.UserControlleres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.CardEntity;
import org.example.Models.Entities.UserEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.UserViews.RegisterEditView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class RegisterController implements CoreController {
    private static final Logger  logger = LogManager.getLogger(RegisterController.class);

    private UserBehavior model;
    private RegisterEditView view;
    public RegisterController() throws IOException {
        model = UserBehavior.singelton();
        view = new RegisterEditView();
        ActionListener actionListener = e ->register();
        view.setRegisterButton(actionListener);
    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
    public void register(){
        UserEntity user = ValidationUser.getFeilds(view);
        if (user != null){
            boolean result = ValidationUser.validateUser(user, view);
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


}
