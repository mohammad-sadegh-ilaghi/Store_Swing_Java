package org.example.Models.Behavior.BehaviorInterfaces;

import org.example.Models.Entities.CoolSystemEntity;

public interface CoolSystemBehavior {
    boolean buy(CoolSystemEntity coolSystem);
    boolean create(CoolSystemEntity coolSystem);
    boolean edit(CoolSystemEntity coolSystem);
    boolean remove(CoolSystemEntity coolSystem);

}
