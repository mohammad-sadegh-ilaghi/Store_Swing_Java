package org.example.Controllers.UserControlleres;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Configure.UserConfigure;
import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.UserEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.UserViews.RegisterEditView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class EditUserController implements CoreController {

    private static final Logger logger = LogManager.getLogger(RegisterController.class);

    private UserBehavior model;
    private RegisterEditView view;
    public EditUserController() throws IOException {
        UserConfigure userConfigure = UserConfigure.singlton();
        model = UserBehavior.singelton();
        view = new RegisterEditView(userConfigure.getUser());
        ActionListener actionListener = e -> submit();
        view.setRegisterButton(actionListener);
    }
    public void submit(){
        UserEntity user = ValidationUser.getFeilds(view);
        if (user != null){
            boolean result = ValidationUser.validateUser(user, view);
            if (result){
                try {
                    result = model.edit(user);
                    UserConfigure.singlton().login(user);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
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
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
}
