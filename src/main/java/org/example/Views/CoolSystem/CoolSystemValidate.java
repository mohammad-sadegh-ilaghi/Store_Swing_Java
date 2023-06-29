package org.example.Views.CoolSystem;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Views.AirConditionerViews.CreateEditAirConditionerView;

import java.math.BigInteger;
import java.time.LocalDate;

public class CoolSystemValidate {
    public static CoolSystemEntity getFields(CoolSystemCreateView view) {
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
        CoolSystemEntity coolSystem = new CoolSystemEntity(brand, createdDate, made, numbers, power,
                isNew, warranty, energyLabel, weight);
        if (!view.getId().getText().trim().equals(""))
            coolSystem.setId(new BigInteger(view.getId().getText()));
        if (!view.getId().getText().trim().equals(""))
            coolSystem.setId(new BigInteger(view.getId().getText()));
        return coolSystem;
    }
    public static boolean validatAirConditioner(CoolSystemEntity coolSystem, CoolSystemCreateView view){
        boolean result = true;
        if (coolSystem.getBrand().trim().equals("")){
            result = false;
            view.setBrandValidate("Brand is empty");
        }else
            view.setBrandValidate("");
        if (!coolSystem.getDateOfCreated().isBefore(LocalDate.now())){
            view.setCreatedDateValidate("Date time is invalid");
            result = false;
        }else
            view.setCreatedDateValidate("");
        if (coolSystem.getMade().trim().equals("")){
            view.setMadeValidate("The made feilds is empty!!!");
            result = false;
        }else
            view.setMadeValidate("");

        if (coolSystem.getNumbers()<= 0){
            view.setNumbersValidate("Number must be more than one and integer.");
            result = false;
        }else
            view.setNumbersValidate("");
        if (coolSystem.getPower().trim().equals("")){
            view.setPowerValidate("Power not must be empty");
            result = false;
        }else
            view.setPowerValidate("");
        if (coolSystem.getWarranty().isBefore(LocalDate.now())){
            view.setWarrantyValidate("The Warranty must be after today");
            result = false;
        }else
            view.setWarrantyValidate("");
        if (coolSystem.getWeight().trim().equals("")){
            view.setWeightValidate("Weight should be entered!!!");
            result = false;
        }else
            view.setWeightValidate("");
        return result;
    }
}
