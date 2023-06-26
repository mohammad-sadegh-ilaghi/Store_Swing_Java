package org.example.Controllers.UserControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.UserBehavior;
import org.example.Views.UserViews.CardView;

import javax.swing.*;
import java.io.IOException;

public class CardUserController implements CoreController {
    private UserBehavior model;
    private CardView view;
    public CardUserController() throws IOException {
        model= UserBehavior.singelton();
        view = new CardView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
