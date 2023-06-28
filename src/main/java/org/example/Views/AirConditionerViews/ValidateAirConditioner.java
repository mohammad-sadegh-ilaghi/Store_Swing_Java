package org.example.Views.AirConditionerViews;

import org.example.Models.Entities.AirConditionerEntity;

import java.math.BigInteger;
import java.time.LocalDate;

public class ValidateAirConditioner {

    public static AirConditionerEntity getFields(CreateEditAirConditionerView view){
        String brand = view.getBrand().getText();
        LocalDate createdDate =  ((java.util.Date)view.getCreatedDate().getValue()).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        String made = view.getMade().getText();
        int numbers = -1;
        if (view.getNumbers().getText().matches("-?\\d+(\\.\\d+)?"))
            numbers = Integer.parseInt(view.getNumbers().getText());
        String power = view.getPower().getText();
        boolean isNew = view.getIsNew().isSelected();
        LocalDate warranty = ((java.util.Date)view.getWarranty().getValue()).toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        String energyLabel = view.getEnergyLabel().getSelectedItem().toString();
        String weight = view.getWeight().getText();
        String theOutputIsTwoWay = view.getTheOutputIsTwoWay().getText();
        String coolingCapacityBTUh = view.getCoolingCapacityBTUh().getText();
        String coolingCapacityKw = view.getCoolingCapacityKw().getText();
        String heatingCapacityBTUh = view.getHeatingCapacityBTUh().getText();
        String threeRowCoil = view.getThreeRowCoil().getText();
        AirConditionerEntity airConditionerEntity = new AirConditionerEntity(brand, createdDate, made, numbers, power,
                isNew, warranty, energyLabel, weight, theOutputIsTwoWay,
                coolingCapacityBTUh, coolingCapacityKw, heatingCapacityBTUh,threeRowCoil);
        if (!view.getId().getText().trim().equals(""))
            airConditionerEntity.setId(new BigInteger(view.getId().getText()));
        return airConditionerEntity;
    }

    public static boolean validatAirConditioner(AirConditionerEntity airConditioner, CreateEditAirConditionerView view){
        boolean result = true;
        if (airConditioner.getBrand().trim().equals("")){
            result = false;
            view.setBrandValidate("Brand is empty");
        }else
            view.setBrandValidate("");
        if (!airConditioner.getDateOfCreated().isBefore(LocalDate.now())){
            view.setCreatedDateValidate("Date time is invalid");
            result = false;
        }else
            view.setCreatedDateValidate("");
        if (airConditioner.getMade().trim().equals("")){
            view.setMadeValidate("The made feilds is empty!!!");
            result = false;
        }else
            view.setMadeValidate("");

        if (airConditioner.getNumbers()<= 0){
            view.setNumbersValidate("Number must be more than one and integer.");
            result = false;
        }else
            view.setNumbersValidate("");
        if (airConditioner.getPower().trim().equals("")){
            view.setPowerValidate("Power not must be empty");
            result = false;
        }else
            view.setPowerValidate("");
        if (airConditioner.getWarranty().isBefore(LocalDate.now())){
            view.setWarrantyValidate("The Warranty must be after today");
            result = false;
        }else
            view.setWarrantyValidate("");
        if (airConditioner.getWeight().trim().equals("")){
            view.setWeightValidate("Weight should be entered!!!");
            result = false;
        }else
            view.setWeightValidate("");
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
