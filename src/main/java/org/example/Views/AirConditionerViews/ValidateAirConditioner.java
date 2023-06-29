package org.example.Views.AirConditionerViews;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Views.CoolSystem.CoolSystemValidate;

import java.math.BigInteger;
import java.time.LocalDate;

public class ValidateAirConditioner {

    public static AirConditionerEntity getFields(CreateEditAirConditionerView view){
        CoolSystemEntity coolSystem = CoolSystemValidate.getFields(view);
        String theOutputIsTwoWay = view.getTheOutputIsTwoWay().getText();
        String coolingCapacityBTUh = view.getCoolingCapacityBTUh().getText();
        String coolingCapacityKw = view.getCoolingCapacityKw().getText();
        String heatingCapacityBTUh = view.getHeatingCapacityBTUh().getText();
        String threeRowCoil = view.getThreeRowCoil().getText();
        AirConditionerEntity airConditionerEntity = new AirConditionerEntity(coolSystem, theOutputIsTwoWay,
                coolingCapacityBTUh, coolingCapacityKw, heatingCapacityBTUh,threeRowCoil);
        if (!view.getId().getText().trim().equals(""))
            airConditionerEntity.setId(new BigInteger(view.getId().getText()));
        return airConditionerEntity;
    }

    public static boolean validatAirConditioner(AirConditionerEntity airConditioner, CreateEditAirConditionerView view){
        boolean result = true;
        result = CoolSystemValidate.validatAirConditioner(airConditioner, view);
        if (airConditioner.getTheOutputIsTwoWay().trim().equals("")){
            result = false;
            view.setTheOutputIsTwoWayValidate("the (the Output Is Two-Way) should enetered!!!");
        }else
            view.setTheOutputIsTwoWayValidate("");
        if (airConditioner.getCoolingCapacityBTUh().trim().equals("")){
            result = false;
            view.setCoolingCapacityBTUhValidate("the (cooling Capacity BTU/h) should entered");
        }else
            view.setCoolingCapacityBTUhValidate("");
        if (airConditioner.getCoolingCapacityKw().trim().equals("")){
            result = false;
            view.setCoolingCapacityKwValidate("the (cooling Capacity Kw) should be enetered");
        }else
            view.setCoolingCapacityKwValidate("");
        if (airConditioner.getHeatingCapacityBTUh().trim().equals("")){
            view.setHeatingCapacityBTUhValidate("the () should be entered!!!");
            result = false;
        }else
            view.setHeatingCapacityBTUhValidate("");
        if (airConditioner.getThreeRowCoil().trim().equals("")){
            result = false;
            view.setThreeRowCoilValidate("the (Three Row Coil) should be enetered!!!");
        }else
            view.setThreeRowCoilValidate("");
        return result;
    }

}
