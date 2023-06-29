package org.example.Views;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Configure.UserConfigure;
import org.example.Controllers.AirConditionerControlleres.CreateEditAirConditionerController;
import org.example.Controllers.AirConditionerControlleres.ListAirConditioerController;
import org.example.Controllers.FanControlleres.CreateEditFanController;
import org.example.Controllers.FanControlleres.ListFanController;
import org.example.Controllers.UserControlleres.EditUserController;
import org.example.Controllers.UserControlleres.ListOfBoughtProductController;
import org.example.Controllers.UserControlleres.LoginController;
import org.example.Controllers.UserControlleres.RegisterController;
import org.example.Controllers.WaterCoolerControlleres.CreateEditWaterCoolerController;
import org.example.Controllers.WaterCoolerControlleres.ListWaterCoolerController;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Rules.RulesUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CoreMiddleWare {
    private static CoreMiddleWare instance;
    private JFrame frame;
    private JPanel panel;
    private static final Logger logger = LogManager.getLogger(AirConditionerBehavior.class);
    MenuBar menuBar = new MenuBar();
    //<editor-fold defaultstate="collapsed" desc="menu">

    Menu fanMenu = new Menu("Fan");
    Menu airConditionerMenu = new Menu("Air Conditioner");
    Menu waterCoolMenu = new Menu("WaterCooler");
    Menu userMenu = new Menu("User");
    Menu helpMenu = new Menu("help");
    Menu file = new Menu("File");

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" menu itemes">

    // fan itemes
    MenuItem fanCreateItem = new MenuItem("Create");
    MenuItem fanListItem = new MenuItem("Fanes");
    // airConditioner itemes
    MenuItem airConditionerCreateItem = new MenuItem("Create");
    MenuItem airConditionerListItem = new MenuItem("Air Conditioneres");
    // user itemes
    MenuItem userLoginItem = new MenuItem("Login");
    MenuItem userRegisterItem = new MenuItem("Register");
    MenuItem userEditItem = new MenuItem("User Edit");
    MenuItem userBought = new MenuItem("User bought");
    MenuItem logout = new MenuItem("logout");
    // file
    MenuItem fileAll = new MenuItem("Export file text All");
    MenuItem fileAirConditioner = new MenuItem("Export file text AirCondition");
    MenuItem fileFans = new MenuItem("Export file text FanCooler");
    MenuItem fileWaterCooler = new MenuItem("Export file text WaterCooler");
    MenuItem fileBoughtProduct = new MenuItem("Export file text bought products");


    // watercool itemes
    MenuItem waterCoolCreateItem = new MenuItem("Create");
    MenuItem waterCoolListItem = new MenuItem("waterCooles");

    // help
    MenuItem aboutMenu = new MenuItem("about");
    //</editor-fold>

    public static CoreMiddleWare singelton(){
        if (instance== null)
            instance = new CoreMiddleWare();
        return instance;
    }
    private CoreMiddleWare(){
        // frame and panel
        frame = new JFrame();

        panel =new JPanel(new BorderLayout());

        loadFrame();

        frame.setSize(new Dimension(400, 400));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void repainAndReValidatePanel(){
        panel.revalidate();
        panel.repaint();
    }
    public void loadFrame(){
        loadMenus();
        UserConfigure user = UserConfigure.singlton();
        frame.remove(menuBar);
        setPanel(new JPanel());
        menuBar = new MenuBar();
        userMenu.removeAll();

        if (user.isLogin()){
            menuBar.add(fanMenu);
            menuBar.add(airConditionerMenu);
            menuBar.add(waterCoolMenu);
            userMenu.add(userEditItem);
            userMenu.add(logout);

            fanMenu.add(fanListItem);
            airConditionerMenu.add(airConditionerListItem);
            waterCoolMenu.add(waterCoolListItem);
            //<editor-fold defaultstate="collapsed" desc="User ActionListerner">
            userEditItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    EditUserController editUserController = null;
                    try {
                        editUserController = new EditUserController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(editUserController.getPanel());
                }
            });
            logout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    UserConfigure.singlton().logOut();
                    loadFrame();
                    loadMenus();
                }
            });

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc=" Product ActionListener">

            fanListItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListFanController fan = null;
                    try {
                        fan = new ListFanController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                        throw new RuntimeException(ex);
                    }
                    setPanel(fan.getPanel());
                }
            });
            waterCoolListItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListWaterCoolerController waterCooler = null;
                    try {
                        waterCooler = new ListWaterCoolerController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(waterCooler.getPanel());
                }
            });
            airConditionerListItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListAirConditioerController airConditioerController = null;
                    try {
                        airConditioerController = new ListAirConditioerController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(airConditioerController.getPanel());
                }
            });
            //</editor-fold >
            //<editor-fold defaultstate="collapsed" desc="Files actionListener">
            fileAll.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            fileFans.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            fileWaterCooler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            fileAirConditioner.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });


            //</editor-fold>
        }
        if (user.isLogin() && user.getUser().getUserRule().equals(RulesUser.ADMIN)){
            //<editor-fold defaultstate="collapsed" desc="add menues to menubar and menubar to frame">



            //add fan items
            fanMenu.add(fanCreateItem);


            //add airConditioner items
            airConditionerMenu.add(airConditionerCreateItem);

            //add user item
            // add waterCool item
            waterCoolMenu.add(waterCoolCreateItem);
            //</editor-fold>


            //<editor-fold defaultstate="collapsed" desc="fan action listerneres items">


            fanCreateItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateEditFanController fan = null;
                    try {
                        fan = new CreateEditFanController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(fan.getPanel());
                }
            });

            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="waterCooler items">


            waterCoolCreateItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateEditWaterCoolerController waterCooler= null;
                    try {
                        waterCooler = new CreateEditWaterCoolerController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(waterCooler.getPanel());
                }
            });
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="airConditioner items">
            airConditionerCreateItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateEditAirConditionerController airConditioerController= null;
                    try {
                        airConditioerController = new CreateEditAirConditionerController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(airConditioerController.getPanel());
                }
            });

            //</editor-fold>



        }
        else if (user.isLogin() && user.getUser().getUserRule().equals(RulesUser.USER)){
            userMenu.add(userBought);
            userBought.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListOfBoughtProductController  list = new ListOfBoughtProductController();
                    setPanel(list.getPanel());
                }
            });
            fileBoughtProduct.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

        }
        else if (!user.isLogin()){
            //<editor-fold defaultstate="collapsed" desc="user items">
            //add user item
            userMenu.add(userLoginItem);
            userMenu.add(userRegisterItem);
            //</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="User actions">
            userLoginItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    LoginController login = null;
                    try {
                        login = new LoginController();
                    } catch (IOException ex) {
                        logger.fatal(ex.getMessage());
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
                        logger.fatal(ex.getMessage());
                    }
                    setPanel(register.getPanel());
                }
            });

            //</editor-fold>

        }





        menuBar.add(userMenu);

        //help
        menuBar.add(helpMenu);
        helpMenu.add(aboutMenu);


        //<editor-fold defaultstate="collapsed" desc="about">
        aboutMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AboutMenuBarView.getPanel();
            }
        });
        //</editor-fold>
        if (!UserConfigure.singlton().isLogin()){
            LoginController loginController = null;
            try {
                loginController = new LoginController();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            panel.add(loginController.getPanel());
        }

        frame.setMenuBar(menuBar);
        frame.add(panel);

    }
    public void setPanel(JPanel panelReplace){
        panel.removeAll();
        panel.add(panelReplace);
        panel.revalidate();
        panel.repaint();
    }
    public void loadMenus(){
        fanMenu = new Menu("Fan");
        airConditionerMenu = new Menu("Air Conditioner");
        waterCoolMenu = new Menu("WaterCooler");
        userMenu = new Menu("User");
        helpMenu = new Menu("help");
    }
}
