package org.example.Views;

import org.example.Controllers.AirConditionerControlleres.CreateEditAirConditionerController;
import org.example.Controllers.AirConditionerControlleres.ListAirConditioerController;
import org.example.Controllers.FanControlleres.CreateEditFanController;
import org.example.Controllers.FanControlleres.ListFanController;
import org.example.Controllers.UserControlleres.CardUserController;
import org.example.Controllers.UserControlleres.LoginController;
import org.example.Controllers.UserControlleres.RegisterController;
import org.example.Controllers.WaterCoolerControlleres.CreateEditWaterCoolerController;
import org.example.Controllers.WaterCoolerControlleres.ListWaterCoolerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CoreMiddleWare {
    private JFrame frame;
    private JPanel panel;
    JMenuBar menuBar = new JMenuBar();
    //<editor-fold defaultstate="collapsed" desc="menu">

    JMenu fanMenu = new JMenu("Fan");
    JMenu airConditionerMenu = new JMenu("Air Conditioner");
    JMenu waterCoolMenu = new JMenu("WaterCooler");
    JMenu userMenu = new JMenu("User");
    JMenu aboutMenu = new JMenu("about");
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" menu itemes">

    // fan itemes
    JMenuItem fanCreateItem = new JMenuItem("Create");
    JMenuItem fanListItem = new JMenuItem("Fanes");
    // airConditioner itemes
    JMenuItem airConditionerCreateItem = new JMenuItem("Create");
    JMenuItem airConditionerListItem = new JMenuItem("Air Conditioneres");
    // user itemes
    JMenuItem userLoginItem = new JMenuItem("Login");
    JMenuItem userRegisterItem = new JMenuItem("Register");
    JMenuItem userCardBankItem = new JMenuItem("Bank card");
    // watercool itemes
    JMenuItem waterCoolCreateItem = new JMenuItem("Create");
    JMenuItem waterCoolListItem = new JMenuItem("waterCooles");
    //</editor-fold>

    public CoreMiddleWare(){
        // frame and panel
        frame = new JFrame();
        panel =new JPanel(new BorderLayout());

        //<editor-fold defaultstate="collapsed" desc="add menues to menubar and menubar to frame">

        menuBar.add(fanMenu);
        menuBar.add(airConditionerMenu);
        menuBar.add(waterCoolMenu);
        menuBar.add(userMenu);
        menuBar.add(aboutMenu);

        frame.add(menuBar);

        //add fan items
        fanMenu.add(fanCreateItem);
        fanMenu.add(fanListItem);


        //add airConditioner items
        airConditionerMenu.add(airConditionerCreateItem);
        airConditionerMenu.add(airConditionerListItem);

        //add user item
        userMenu.add(userLoginItem);
        userMenu.add(userRegisterItem);
        userMenu.add(userCardBankItem);

        // add waterCool item
        waterCoolMenu.add(waterCoolCreateItem);
        waterCoolMenu.add(waterCoolListItem);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="action listerneres">

        //<editor-fold desc="fanCreate">

        fanCreateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateEditFanController fan = null;
                try {
                    fan = new CreateEditFanController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(fan.getPanel());
            }
        });
        fanListItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListFanController fan = null;
                try {
                    fan = new ListFanController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(fan.getPanel());
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="waterCooler">

        waterCoolListItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListWaterCoolerController waterCooler = null;
                try {
                    waterCooler = new ListWaterCoolerController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(waterCooler.getPanel());
            }
        });
        waterCoolCreateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateEditWaterCoolerController waterCooler= null;
                try {
                    waterCooler = new CreateEditWaterCoolerController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(waterCooler.getPanel());
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="airConditioner">
        airConditionerCreateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateEditAirConditionerController airConditioerController= null;
                try {
                    airConditioerController = new CreateEditAirConditionerController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(airConditioerController.getPanel());
            }
        });
        airConditionerListItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListAirConditioerController airConditioerController = null;
                try {
                    airConditioerController = new ListAirConditioerController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(airConditioerController.getPanel());
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="User">
        userLoginItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController login = null;
                try {
                    login = new LoginController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(login.getPanel());
            }
        });
        userRegisterItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterController register = null;
                try {
                    register = new RegisterController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(register.getPanel());
            }
        });
        userCardBankItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardUserController cardUser = null;
                try {
                    cardUser = new CardUserController();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setPanel(cardUser.getPanel());
            }
        });
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="about">
        aboutMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPanel(AboutMenuBarView.getPanel());
            }
        });
        //</editor-fold>

        //</editor-fold>

    }
    public void setPanel(JPanel panelReplace){
        panel.removeAll();
        panel.add(panelReplace);
        panel.revalidate();
        panel.repaint();
    }

}
