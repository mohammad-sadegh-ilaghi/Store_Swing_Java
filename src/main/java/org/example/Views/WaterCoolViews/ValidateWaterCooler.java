package org.example.Views.WaterCoolViews;

import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Views.CoolSystem.CoolSystemValidate;
import org.example.Views.FanViews.CreateEditFanView;
import org.example.Views.FanViews.ValidateFan;

import java.math.BigInteger;

public class ValidateWaterCooler {
    public static WaterCoolerEntity getFields(CreateEditWaterCoolView view){
        String bodyMaterial = view.getBodyMaterial().getText();
        String dimention  = view.getDimention().getText();
        String maximumWindPower = view.getMaximumWindPower().getText();
        String PumpPower = view.getPumpPower().getText();
        String comsumptionWaterPeerHours = view.getComsumptionWaterPeerHours().getText();
        boolean remoteController = view.getRemoteController().isSelected();
        WaterCoolerEntity waterCooler = new WaterCoolerEntity(CoolSystemValidate.getFields(view), bodyMaterial, dimention, maximumWindPower, PumpPower, comsumptionWaterPeerHours, remoteController);
        if (!view.getId().getText().trim().equals(""))
            waterCooler.setId(new BigInteger(view.getId().getText()));
        return waterCooler;
    }
    public static boolean validatWaterCooler(WaterCoolerEntity waterCoole, CreateEditWaterCoolView view){
        boolean result = true;
        result = CoolSystemValidate.validatAirConditioner(waterCoole, view);
        if (waterCoole.getBodyMaterial().trim().equals("")){
            view.setBodyMaterialValidate("Body Material is empty!!!");
            result = false;
        }
        else
            view.setBodyMaterialValidate("");
        if (waterCoole.getDimention().trim().equals("")){
            view.setDimentionValidate("Dimention is empty");
            result = false;
        }
        else
            view.setDimentionValidate("");
        if (waterCoole.getMaximumWindPower().trim().equals("")){
            view.setMaximumWindPowerValidate("Maximum Wind Power is empty");
            result = false;
        }
        else view.setMaximumWindPowerValidate("");
        if (waterCoole.getPumpPower().trim().equals("")){
            view.setPumpPowerValidate("the PumpPower is Empty");
            result = false;
        }
        else view.setPumpPowerValidate("");
        if (waterCoole.getComsumptionWaterPeerHours().trim().equals("")){
            view.setComsumptionWaterPeerHoursValidate("the comsumption Water Peer Hours is empty");
            result =false;
        }
        else view.setComsumptionWaterPeerHoursValidate("");

        return result;
    }


    }
