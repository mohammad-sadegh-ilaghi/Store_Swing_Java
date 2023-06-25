package org.example.Models.Behavior;

import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;

import java.util.ArrayList;

public class AirConditionerBehavior implements CoolSystemBehavior {
    private ArrayList<AirConditionerEntity> airConditioneres;
    public AirConditionerBehavior(){
        airConditioneres = new ArrayList<>();
    }
    public AirConditionerBehavior(ArrayList<AirConditionerEntity> airConditioneres){
        this.airConditioneres = airConditioneres;
    }

    public ArrayList<AirConditionerEntity> getAirConditioneres() {
        return airConditioneres;
    }

    public void setAirConditioneres(ArrayList<AirConditionerEntity> airConditioneres) {
        this.airConditioneres = airConditioneres;
    }

    @Override
    public boolean buy(CoolSystemEntity coolSystem) {
        AirConditionerEntity airConditionerEntity = airConditioneres.stream().filter(item -> item.getId() == coolSystem.getId()).toList().get(0);
        airConditionerEntity.setNumbers(airConditionerEntity.getNumbers() - 1);
        return true;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        AirConditionerEntity airConditionerEntity = (AirConditionerEntity) coolSystem;
        airConditioneres.add(airConditionerEntity);
        return true;
    }

    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        AirConditionerEntity airConditionerEntity = airConditioneres.stream().filter(item -> item.getId() == coolSystem.getId()).toList().get(0);
        airConditionerEntity = (AirConditionerEntity) coolSystem;
        return true;
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) {
        return airConditioneres.removeIf(item -> coolSystem.getId() == item.getId() );
    }
}
