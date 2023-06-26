package org.example.Controllers;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CoreController {
    private JFrame frame;
    private JPanel panel;
    JMenuBar menuBar = new JMenuBar();
    // menu
    JMenu fanMenu = new JMenu("Fan");
    JMenu airConditionerMenu = new JMenu("Air Conditioner");
    JMenu waterCoolMenu = new JMenu("WaterCooler");
    JMenu userMenu = new JMenu("User");
    // menu itemes
        // fan itemes
        JMenuItem fanCreateItem = new JMenuItem("Create");
        JMenuItem fanEditItem = new JMenuItem("Edit");
        JMenuItem fanListItem = new JMenuItem("Fanes");
        // airConditioner itemes
        JMenuItem airConditionerCreateItem = new JMenuItem("Create");
        JMenuItem airConditionerEditItem = new JMenuItem("Edit");
        JMenuItem airConditionerListItem = new JMenuItem("Air Conditioneres");
        // user itemes
        JMenuItem userLoginItem = new JMenuItem("Login");
        JMenuItem userRegisterItem = new JMenuItem("Register");
        JMenuItem userCardBankItem = new JMenuItem("Bank card");
        // watercool itemes
        JMenuItem waterCoolCreateItem = new JMenuItem("Create");
        JMenuItem waterCoolEditItem = new JMenuItem("Edit");
        JMenuItem waterCoolListItem = new JMenuItem("waterCooles");

    public CoreController(){
        // frame and panel
        frame = new JFrame();
        panel =new JPanel(new BorderLayout());

        //add fan items
        fanMenu.add(fanCreateItem);
        fanMenu.add(fanEditItem);
        fanMenu.add(fanListItem);

        //add airConditioner items
        airConditionerMenu.add(airConditionerCreateItem);
        airConditionerMenu.add(airConditionerEditItem);
        airConditionerMenu.add(airConditionerListItem);

        //add user item
        userMenu.add(userLoginItem);
        userMenu.add(userRegisterItem);
        userMenu.add(userCardBankItem);

        // add waterCool item
        waterCoolMenu.add(waterCoolCreateItem);
        waterCoolMenu.add(waterCoolEditItem);
        waterCoolMenu.add(waterCoolListItem);
    }
    public static void main(String[] args){
        Date currentDate = new Date();
        System.out.println(currentDate);
    }
}
