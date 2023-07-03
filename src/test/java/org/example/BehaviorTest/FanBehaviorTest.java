package org.example.BehaviorTest;

import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Enumes.EnergyLables;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FanBehaviorTest {

    @DisplayName("Test FanEntityTest.create()")
    @Test
    void createTest(){
        FanEntitiyBehavior fanEntitiyBehavior = null;
        try {
            fanEntitiyBehavior = FanEntitiyBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        FanEntity fan = new FanEntity(coolSystem, 200, "df", true, "fdj", "jf", 348);
        int length = fanEntitiyBehavior.getFans().size();

        try {
            fanEntitiyBehavior.create(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(length + 1, fanEntitiyBehavior.getFans().size());
        try {
            fanEntitiyBehavior.remove(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DisplayName("Test FanEntityTest.delete()")
    @Test
    void deleteTest(){
        FanEntitiyBehavior fanEntitiyBehavior = null;
        try {
            fanEntitiyBehavior = FanEntitiyBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        FanEntity fan = new FanEntity(coolSystem, 200, "df", true, "fdj", "jf", 348);
        int length = fanEntitiyBehavior.getFans().size();

        try {
            fanEntitiyBehavior.create(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fanEntitiyBehavior.remove(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(length, fanEntitiyBehavior.getFans().size());

    }

    @DisplayName("Test FanEntityTest.buy()")
    @Test
    void buyTest(){
        FanEntitiyBehavior fanEntitiyBehavior = null;
        try {
            fanEntitiyBehavior = FanEntitiyBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        FanEntity fan = new FanEntity(coolSystem, 200, "df", true, "fdj", "jf", 348);

        try {
            fanEntitiyBehavior.create(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(3, fanEntitiyBehavior.getFan(fan.getId()).getNumbers());

        try {
            fanEntitiyBehavior.buy(fan, 100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fanEntitiyBehavior.remove(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DisplayName("Test FanEntityTest.buy2()")
    @Test
    void buyTest2(){
        FanEntitiyBehavior fanEntitiyBehavior = null;
        try {
            fanEntitiyBehavior = FanEntitiyBehavior.singelton();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 300, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        FanEntity fan = new FanEntity(coolSystem, 200, "df", true, "fdj", "jf", 348);

        try {
            fanEntitiyBehavior.create(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fanEntitiyBehavior.buy(fan, 300);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(0, fanEntitiyBehavior.getFan(fan.getId()).getNumbers());

        try {
            fanEntitiyBehavior.remove(fan);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
