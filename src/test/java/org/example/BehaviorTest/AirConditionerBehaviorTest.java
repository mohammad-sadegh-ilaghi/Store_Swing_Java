package org.example.BehaviorTest;

import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Enumes.EnergyLables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirConditionerBehaviorTest {
    @DisplayName("Test AirConditioenr.addAirConditionerTest()")
    @Test
    void addAirConditionerTest() {
        AirConditionerBehavior airConditionerBehavior = null;
        try {
             airConditionerBehavior = AirConditionerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        AirConditionerEntity airConditioner = new AirConditionerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf");
        int length = airConditionerBehavior.getAirConditioneres().size();
        airConditionerBehavior.create(airConditioner);
        assertEquals(length+1, airConditionerBehavior.getAirConditioneres().size());
        airConditionerBehavior.remove(airConditioner.getId());
    }
    @DisplayName("Test AirConditioenr.removeAirConditionerTest()")
    @Test
    void remove(){
        AirConditionerBehavior airConditionerBehavior = null;
        try {
            airConditionerBehavior = AirConditionerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        AirConditionerEntity airConditioner = new AirConditionerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf");
        int length = airConditionerBehavior.getAirConditioneres().size();
        airConditionerBehavior.create(airConditioner);
        airConditionerBehavior.remove(airConditioner.getId());
        assertEquals(length, airConditionerBehavior.getAirConditioneres().size());
    }
    @DisplayName("Test AirConditioenr.buyAirConditionerTest()")
    @Test
    void buyTest(){
        AirConditionerBehavior airConditionerBehavior = null;
        try {
            airConditionerBehavior = AirConditionerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        AirConditionerEntity airConditioner = new AirConditionerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf");
        airConditionerBehavior.create(airConditioner);
        try {
            airConditionerBehavior.buy(airConditioner, 300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, airConditionerBehavior.getAirConditioner(airConditioner.getId()).getNumbers());
        airConditionerBehavior.remove(airConditioner.getId());

    }
    void buy2Test(){
        AirConditionerBehavior airConditionerBehavior = null;
        try {
            airConditionerBehavior = AirConditionerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 100, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        AirConditionerEntity airConditioner = new AirConditionerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf");
        airConditionerBehavior.create(airConditioner);
        try {
            airConditionerBehavior.buy(airConditioner, 100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, airConditionerBehavior.getAirConditioner(airConditioner.getId()).getNumbers());
        airConditionerBehavior.remove(airConditioner.getId());
    }
}
