package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Views.UserViews.RegisterView;

import javax.swing.*;
import java.io.IOException;

public class RegisterController implements CoreController {
    private UserBehavior model;
    private RegisterView view;
    public RegisterController() throws IOException {
        model = UserBehavior.singelton();
        view = new RegisterView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
