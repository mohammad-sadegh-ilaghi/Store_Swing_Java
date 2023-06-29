package org.example.Views.FanViews;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Views.AirConditionerViews.CreateEditAirConditionerView;
import org.example.Views.CoolSystem.CoolSystemValidate;

import java.math.BigInteger;
import java.time.LocalDate;

public class ValidateFan {
    public static FanEntity getFields(CreateEditFanView view){
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
        int length =-1;
        if (view.getLength().getText().matches("-?\\d+(\\.\\d+)?"))
            length = Integer.parseInt(view.getLength().getText());
        String type = view.getType().getText();
        boolean haveremoteController = view.getHaveremoteController().isSelected();
        String dimension = view.getDimension().getText();
        String windVolume = view.getWindVolume().getText();
        int lengthOfCable = 0;
        if (view.getLength().getText().matches("-?\\d+(\\.\\d+)?"))
            lengthOfCable  = Integer.parseInt(view.getLengthOfCable().getText());
        FanEntity fan = new FanEntity(brand, createdDate, made, numbers, power,
                isNew, warranty, energyLabel, weight, length,
                type, haveremoteController, dimension,windVolume, lengthOfCable);
        if (!view.getId().getText().trim().equals(""))
            fan.setId(new BigInteger(view.getId().getText()));
        return fan;
    }

    public static boolean validatAirConditioner(FanEntity fan, CreateEditFanView view){
        boolean result = true;
        result = CoolSystemValidate.validatAirConditioner(fan, view);
        if (fan.getLength() <= 30){
            result = false;
            view.setLengthValidate("the length must more than 30cm!!!");
        }else
            view.setLengthValidate("");
        if (fan.getType().trim().equals("")){
            result = false;
            view.setTypeValidate("the (cooling Capacity BTU/h) should entered");
        }else
            view.setTypeValidate("");
        if (fan.getDimension().trim().equals("")){
            result = false;
            view.setDimensionValidate("the (cooling Capacity Kw) should be enetered");
        }else
            view.setDimensionValidate("");
        if (fan.getWindVolume().trim().equals("")){
            view.setWindVolumeValidate("the () should be entered!!!");
            result = false;
        }else
            view.setWindVolumeValidate("");
        if (fan.getWindVolume().trim().equals("")){
            result = false;
            view.setWindVolumeValidate("the (Three Row Coil) should be enetered!!!");
        }else
            view.setWindVolumeValidate("");
        if (fan.getLengthOfCable() <= 0){
            result = false;
            view.setLengthOfCableValidate("length of cable must be more than zero ");
        }
        else
            view.setLengthOfCableValidate("");
        if (fan.getLengthOfCable() <= 0){
            result =false;
            view.setLengthOfCableValidate("length of cable should be interger and posetive");
        }
        else
            view.setLengthOfCableValidate("");

        return result;
    }

}
