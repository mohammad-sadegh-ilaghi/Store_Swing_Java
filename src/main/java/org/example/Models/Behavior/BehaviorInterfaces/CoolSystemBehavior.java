package org.example.Models.Behavior.BehaviorInterfaces;

import org.example.Models.Entities.CoolSystemEntity;

import java.io.IOException;

public interface CoolSystemBehavior {
    boolean buy(CoolSystemEntity coolSystem) throws IOException;
    boolean create(CoolSystemEntity coolSystem) throws IOException;
    boolean edit(CoolSystemEntity coolSystem) throws IOException;
    boolean remove(CoolSystemEntity coolSystem) throws IOException;
}
