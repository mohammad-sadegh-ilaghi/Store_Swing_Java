package org.example.BehaviorTest;

import org.example.Models.Behavior.ProductBoughtBehavior;
import org.example.Models.Behavior.UserBehavior;
import org.example.Models.Entities.CardEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Entities.ProductBought;
import org.example.Models.Entities.UserEntity;
import org.example.Models.Enumes.EnergyLables;
import org.example.Rules.RulesUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserBehaviorTest {
    @DisplayName("Test ProductBought.create()")
    @Test
    void createTest(){
        UserEntity user = null;
        CardEntity card = new CardEntity(2389, "jsif", 23479);
        try {
            user = new UserEntity("mohammad", "isdj", "sfiuh","ndi@mf.co",card, RulesUser.USER);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(true,UserBehavior.singelton().create(user));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @DisplayName("Test ProductBought.create()")
    @Test
    void RemoveTest(){
        CardEntity card = new CardEntity(2389, "jsif", 23479);
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
        try {

            assertEquals(true,UserBehavior.singelton().removeUser(user));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @DisplayName("Test ProductBought.create()")
    @Test
    void loginTest(){
        CardEntity card = new CardEntity(2389, "jsif", 23479);
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
        try {

            assertEquals(true,UserBehavior.singelton().login(user));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
