package org.example.BehaviorTest;

import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Behavior.WaterCoolerBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Models.Enumes.EnergyLables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WaterCoolerBehaviorTest {
    @DisplayName("Test WaterCooler.addAirConditionerTest()")
    @Test
    void addAirConditionerTest() {
        WaterCoolerBehavior waterCoolerBehavior = null;
        try {
            waterCoolerBehavior = WaterCoolerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        WaterCoolerEntity waterCooler = new WaterCoolerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf", true);
        int length = waterCoolerBehavior.getWatercooleres().size();
        waterCoolerBehavior.create(waterCooler);
        assertEquals(length+1, waterCoolerBehavior.getWatercooleres().size());
        waterCoolerBehavior.remove(waterCooler.getId());
    }
    @DisplayName("Test WaterCooler.removeWaterCoolerTest()")
    @Test
    void removeWaterCoolerTest() {
        WaterCoolerBehavior waterCoolerBehavior = null;
        try {
            waterCoolerBehavior = WaterCoolerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        WaterCoolerEntity waterCooler = new WaterCoolerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf", true);
        int length = waterCoolerBehavior.getWatercooleres().size();
        waterCoolerBehavior.create(waterCooler);
        waterCoolerBehavior.remove(waterCooler.getId());
        assertEquals(length, waterCoolerBehavior.getWatercooleres().size());
    }
    @DisplayName("Test WaterCooler.buyWaterCoolerTest()")
    @Test
    void buyWaterCoolerTest() {
        WaterCoolerBehavior waterCoolerBehavior = null;
        try {
            waterCoolerBehavior = WaterCoolerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        WaterCoolerEntity waterCooler = new WaterCoolerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf", true);
        waterCoolerBehavior.create(waterCooler);
        int numbers = waterCoolerBehavior.getWatercooler(waterCooler.getId()).getNumbers();
        assertEquals(false, waterCoolerBehavior.buy(waterCooler, 20));
        waterCoolerBehavior.remove(waterCooler.getId());
    }
    @DisplayName("Test WaterCooler.buyWaterCoolerTest2()")
    @Test
    void buyWaterCoolerTest2() {
        WaterCoolerBehavior waterCoolerBehavior = null;
        try {
            waterCoolerBehavior = WaterCoolerBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 20, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        WaterCoolerEntity waterCooler = new WaterCoolerEntity(coolSystem, "jsd","fjsdoi", "sdif", "jsfdi","sdf", true);
        boolean result = waterCoolerBehavior.create(waterCooler);
        int numbers = waterCoolerBehavior.getWatercooler(waterCooler.getId()).getNumbers();
        assertEquals(true, waterCoolerBehavior.buy(waterCooler, 5));
        waterCoolerBehavior.remove(waterCooler.getId());
    }
}
