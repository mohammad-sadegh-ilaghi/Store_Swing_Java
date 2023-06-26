package org.example.Controllers.FanControlleres;

import org.example.Controllers.CoreController;
import org.example.Controllers.WaterCoolerControlleres.CreateEditWaterCoolerController;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Views.AirConditionerViews.CreateEditAirConditionerView;
import org.example.Views.FanViews.CreateEditFanView;

import javax.swing.*;
import javax.swing.text.View;
import java.io.IOException;

public class CreateEditFanController implements CoreController {
    private CreateEditFanView view;
    private FanEntitiyBehavior model;
    public CreateEditFanController() throws IOException {
        view = new CreateEditFanView();
        model = FanEntitiyBehavior.singelton();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
