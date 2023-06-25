package org.example.Models.Behavior;

import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.WaterCoolerEntity;

import java.util.ArrayList;

public class WaterCoolerBehavior implements CoolSystemBehavior {
    private ArrayList<WaterCoolerEntity> watercooleres;
    public WaterCoolerBehavior(ArrayList<WaterCoolerEntity> watercooleres){
        this.watercooleres = watercooleres;
    }
    @Override
    public boolean buy(CoolSystemEntity coolSystem) {

        return false;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        return false;
    }

    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        return false;
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) {
        return false;
    }
}
