package org.example.BehaviorTest;

import org.example.Models.Behavior.FanEntitiyBehavior;
import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.*;
import org.example.Models.Enumes.EnergyLables;
import org.example.Rules.RulesUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductBoughtBehaivorTest {
    @DisplayName("Test ProductBought.create()")
    @Test
    void createTest(){
        ProductBoughtBehavior productBoughtBehavior = null;
        productBoughtBehavior = ProductBoughtBehavior.singleton();
        CoolSystemEntity coolSystem= new CoolSystemEntity("brand3ed", LocalDate.MIN, "iran", 3, "df", true, LocalDate.MAX, EnergyLables.A.toString(), "89kg");
        CardEntity card = new CardEntity(3434,"jdfi", 2000);
        UserEntity user = null;
        try {
             user = new UserEntity("mohammad", "isdj", "sfiuh","ndi@mf.co",card, RulesUser.USER);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            UserBehavior.singelton().create(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(true, productBoughtBehavior.buy(new ProductBought(user,coolSystem)));
    }
}
