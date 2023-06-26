package org.example.Controllers.AirConditionerControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Views.AirConditionerViews.ListOfAirConditionerView;

import javax.swing.*;
import java.io.IOException;

public class ListAirConditioerController implements CoreController {
    private AirConditionerBehavior model;
    private ListOfAirConditionerView view;
    public ListAirConditioerController() throws IOException {
        model= AirConditionerBehavior.singelton();
        view = new ListOfAirConditionerView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
