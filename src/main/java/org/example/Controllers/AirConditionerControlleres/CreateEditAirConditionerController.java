package org.example.Controllers.AirConditionerControlleres;

import org.apache.logging.log4j.core.Core;
import org.example.Controllers.CoreController;
import org.example.Controllers.FanControlleres.CreateEditFanController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Views.AirConditionerViews.CreateEditAirConditionerView;
import org.example.Views.AirConditionerViews.ValidateAirConditioner;
import org.example.Views.CoreMiddleWare;
import org.example.Views.FanViews.CreateEditFanView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

public class CreateEditAirConditionerController implements CoreController {
    CreateEditAirConditionerView view;
    AirConditionerBehavior model;
    ActionListener submitAction;
    public CreateEditAirConditionerController() throws IOException {
        view = new CreateEditAirConditionerView();
        model = AirConditionerBehavior.singelton();


        submitAction= e -> create();
        view.submitActionLister(submitAction);

    }
    public CreateEditAirConditionerController(AirConditionerEntity airConditioner) throws IOException {
        this();
        view.setValuees(airConditioner);
        view.getSubmit().removeActionListener(submitAction);
        submitAction = e -> edit();
        view.submitActionLister(submitAction);
    }
    public void edit(){
        AirConditionerEntity airConditioner = ValidateAirConditioner.getFields(view);
        boolean result = ValidateAirConditioner.validatAirConditioner(airConditioner, view);
        if (result){
            model.edit(airConditioner);
            try {
                CoreMiddleWare.singelton().setPanel(new ListAirConditioerController().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void create(){
        AirConditionerEntity airConditioner = ValidateAirConditioner.getFields(view);
        boolean result = ValidateAirConditioner.validatAirConditioner(airConditioner, view);
        if (result){
            model.create(airConditioner);
            try {
                CoreMiddleWare.singelton().setPanel(new ListAirConditioerController().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }

}
