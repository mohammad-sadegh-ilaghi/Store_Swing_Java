package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Views.UserViews.CardView;
import org.example.Views.UserViews.EditUserView;

import javax.swing.*;
import java.io.IOException;

public class EditUserController implements CoreController {
    private UserBehavior model;
    private EditUserView view;
    public EditUserController() throws IOException {
        model = UserBehavior.singelton();
        view = new EditUserView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
