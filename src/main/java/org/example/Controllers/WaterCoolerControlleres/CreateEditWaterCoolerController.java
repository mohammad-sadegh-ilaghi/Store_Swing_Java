package org.example.Controllers.WaterCoolerControlleres;

import org.example.Controllers.CoreController;
import org.example.Controllers.FanControlleres.ListFanController;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Views.CoreMiddleWare;
import org.example.Views.FanViews.ValidateFan;
import org.example.Views.WaterCoolViews.CreateEditWaterCoolView;
import org.example.Views.WaterCoolViews.ValidateWaterCooler;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateEditWaterCoolerController implements CoreController {
    private WaterCoolerBehavior model;
    private CreateEditWaterCoolView view;
    private ActionListener submitAction;
    public CreateEditWaterCoolerController() throws IOException {
        model = WaterCoolerBehavior.singelton();
        view = new CreateEditWaterCoolView();
        this.submitAction= e->create();
        view.addActionListenerSubmit(this.submitAction);
    }

    public CreateEditWaterCoolerController(WaterCoolerEntity waterCooler) throws IOException {
        model = WaterCoolerBehavior.singelton();
        view = new CreateEditWaterCoolView();
        this.view.getSubmit().removeActionListener(this.submitAction);
        this.submitAction = e->edit();
        this.view.addActionListenerSubmit(submitAction);
        view.setValuess(waterCooler);
    }
    public void create(){
        WaterCoolerEntity waterCooler = getAndValidate();
        if (waterCooler != null){
            try {
                model.create(waterCooler);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                CoreMiddleWare.singelton().setPanel(new ListWaterCoolerController().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public WaterCoolerEntity getAndValidate(){
        WaterCoolerEntity waterCooler = ValidateWaterCooler.getFields(view);
        boolean result = ValidateWaterCooler.validatWaterCooler(waterCooler, view);
        if (result)
            return waterCooler;
        return null;
    }
    public void edit(){
        WaterCoolerEntity waterCooler = getAndValidate();
        if (waterCooler != null){
            try {
                model.edit(waterCooler);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            try {
                CoreMiddleWare.singelton().setPanel(new ListWaterCoolerController().getPanel());
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
