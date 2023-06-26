package org.example.Controllers.WaterCoolerControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Views.WaterCoolViews.ListWaterCoolView;

import javax.swing.*;
import java.io.IOException;

public class ListWaterCoolerController implements CoreController {
    ListWaterCoolView view;
    WaterCoolerBehavior model;
    public ListWaterCoolerController() throws IOException {
        model = WaterCoolerBehavior.singelton();
        view = new ListWaterCoolView();
    }

    @Override
    public JPanel getPanel() {
        return null;
    }
}
