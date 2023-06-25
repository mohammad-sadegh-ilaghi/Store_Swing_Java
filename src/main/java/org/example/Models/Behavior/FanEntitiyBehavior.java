package org.example.Models.Behavior;

import org.example.Models.Behavior.BehaviorInterfaces.CoolSystemBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class FanEntitiyBehavior implements CoolSystemBehavior {
    private ArrayList<FanEntity> fans;
    public FanEntitiyBehavior(){
        fans = new ArrayList<>();
    }
    public FanEntitiyBehavior(ArrayList<FanEntity> fans){
        this.fans = fans;
    }

    public ArrayList<FanEntity> getFans() {
        return fans;
    }

    public void setFans(ArrayList<FanEntity> fans) {
        this.fans = fans;
    }

    @Override
    public boolean buy(CoolSystemEntity coolSystem) {
        coolSystem.setNumbers(coolSystem.getNumbers() - 1);
        return true;
    }

    @Override
    public boolean create(CoolSystemEntity coolSystem) {
        FanEntity fan = (FanEntity) coolSystem;
        this.fans.add(fan);
        return true;
    }


    @Override
    public boolean edit(CoolSystemEntity coolSystem) {
        FanEntity fan = (FanEntity) coolSystem;
        FanEntity mainFan = fans.stream().filter(item -> item.getId() == item.getId()).collect(Collectors.toList()).get(0);
        mainFan = fan;

        return true;
    }

    @Override
    public boolean remove(CoolSystemEntity coolSystem) {
        return fans.removeIf(item -> item.getId() == coolSystem.getId());
    }

}
