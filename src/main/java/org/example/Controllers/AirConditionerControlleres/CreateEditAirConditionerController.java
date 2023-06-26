package org.example.Controllers.AirConditionerControlleres;

import org.apache.logging.log4j.core.Core;
import org.example.Controllers.CoreController;
import org.example.Controllers.FanControlleres.CreateEditFanController;
import org.example.Models.Behavior.AirConditionerBehavior;

import javax.swing.*;
import java.io.IOException;

public class CreateEditAirConditionerController implements CoreController {
    CreateEditAirConditionerController view;
    AirConditionerBehavior model;
    public CreateEditAirConditionerController() throws IOException {
        view = new CreateEditAirConditionerController();
        model = AirConditionerBehavior.singelton();
    }
    @Override
    public JPanel getPanel() {
        return null;
    }
}
