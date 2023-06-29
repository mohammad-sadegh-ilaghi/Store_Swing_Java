package org.example.Controllers.FanControlleres;

import org.example.Controllers.AirConditionerControlleres.ListAirConditioerController;
import org.example.Controllers.CoreController;
import org.example.Controllers.WaterCoolerControlleres.CreateEditWaterCoolerController;
import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Entities.FanEntity;
import org.example.Views.AirConditionerViews.CreateEditAirConditionerView;
import org.example.Views.CoreMiddleWare;
import org.example.Views.FanViews.CreateEditFanView;
import org.example.Views.FanViews.ListFanView;
import org.example.Views.FanViews.ValidateFan;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CreateEditFanController implements CoreController {
    private CreateEditFanView view;
    private FanEntitiyBehavior model;
    ActionListener submitAction;

    public CreateEditFanController() throws IOException {
        view = new CreateEditFanView();
        model = FanEntitiyBehavior.singelton();
        this.submitAction = e-> create();
        view.addActionListener(submitAction);
    }
    public CreateEditFanController(FanEntity fan) throws IOException {
        this();
        this.view.getSubmit().removeActionListener(this.submitAction);
        this.submitAction = e->edit();
        this.view.addActionListener(submitAction);
        view.setValuess(fan);

    }
    @Override
    public JPanel getPanel() {
        return view.getPanel();
    }
    public void create(){
        FanEntity fan = getAndValidate();
        if (fan != null){
            try {
                model.create(fan);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                CoreMiddleWare.singelton().setPanel(new ListFanController().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public FanEntity getAndValidate(){
        FanEntity fan = ValidateFan.getFields(view);
        boolean result = ValidateFan.validatAirConditioner(fan, view);
        if (result)
            return fan;
        return null;
    }
    public void edit(){
        FanEntity fan = getAndValidate();
        if (fan != null){
            try {
                model.edit(fan);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                CoreMiddleWare.singelton().setPanel(new ListFanController().getPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public CreateEditFanView getView() {
        return view;
    }

    public void setView(CreateEditFanView view) {
        this.view = view;
    }
}
