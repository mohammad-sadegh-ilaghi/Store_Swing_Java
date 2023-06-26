package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Views.UserViews.LoginView;
import org.example.Views.UserViews.RegisterView;

import javax.swing.*;
import java.io.IOException;

public class LoginController implements CoreController {
    private LoginView view;
    private UserBehavior model;
    public LoginController() throws IOException {
        view = new LoginView();
        model = UserBehavior.singelton();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
