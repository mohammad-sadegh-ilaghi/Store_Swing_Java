package org.example.Controllers.WaterCoolerControlleres;

import org.example.Controllers.CoreController;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Views.WaterCoolViews.CreateEditWaterCoolView;

import javax.swing.*;
import java.io.IOException;

public class CreateEditWaterCoolerController implements CoreController {
    private WaterCoolerBehavior model;
    private CreateEditWaterCoolView view;
    public CreateEditWaterCoolerController() throws IOException {
        model = WaterCoolerBehavior.singelton();
        view = new CreateEditWaterCoolView();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
