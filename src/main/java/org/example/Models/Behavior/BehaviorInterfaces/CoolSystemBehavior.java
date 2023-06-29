package org.example.Models.Behavior.BehaviorInterfaces;

import org.example.Models.Entities.CoolSystemEntity;

import java.io.IOException;
import java.math.BigInteger;

public interface CoolSystemBehavior {
    boolean buy(CoolSystemEntity coolSystem) throws IOException;
    boolean create(CoolSystemEntity coolSystem) throws IOException;
    boolean edit(CoolSystemEntity coolSystem) throws IOException;
    boolean remove(BigInteger coolSystem) throws IOException;
}
