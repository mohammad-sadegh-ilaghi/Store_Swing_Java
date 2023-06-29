package org.example.Factory;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;

import java.nio.file.Path;

public class FactoryEntities {
    public static Entities getType(CoolSystemEntity coolSystem){
        if (coolSystem instanceof AirConditionerEntity){
            return Entities.AirConditioner;
        }
        if (coolSystem instanceof FanEntity) {
            return Entities.Fans;
        }
        if (coolSystem instanceof WaterCoolerEntity){
            return Entities.WaterCooler;
        }
        return null;
    }
}
