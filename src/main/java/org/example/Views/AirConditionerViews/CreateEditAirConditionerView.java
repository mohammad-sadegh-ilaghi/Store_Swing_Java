package org.example.Views.AirConditionerViews;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Enumes.EnergyLables;
import org.example.Views.CoolSystem.CoolSystemCreateView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;

public class CreateEditAirConditionerView extends CoolSystemCreateView {
    JPanel panel;

    //<editor-fold defaultstate="collapsed" desc="Form">

    JTextField theOutputIsTwoWay = new JTextField(10);
    JLabel theOutputIsTwoWayLabel = new JLabel("the Output Is Two-Way");
    JLabel theOutputIsTwoWayValidate = new JLabel();

    JTextField coolingCapacityBTUh = new JTextField(10);
    JLabel coolingCapacityBTUhLabel = new JLabel("cooling Capacity BTU/h");
    JLabel coolingCapacityBTUhValidate = new JLabel();

    JTextField coolingCapacityKw = new JTextField(10);
    JLabel coolingCapacityKwLabel = new JLabel("cooling Capacity Kw");
    JLabel coolingCapacityKwValidate = new JLabel();

    JTextField heatingCapacityBTUh= new JTextField(10);
    JLabel heatingCapacityBTUhLabel = new JLabel("heating Capacity BTU/h");
    JLabel heatingCapacityBTUhValidate = new JLabel();

    JTextField ThreeRowCoil = new JTextField(10);
    JLabel ThreeRowCoilLabel = new JLabel("Three Row Coil");
    JLabel ThreeRowCoilValidate = new JLabel();



    JButton submit = new JButton("Submit");
    //</editor-fold>


    public CreateEditAirConditionerView(){
        panel = new JPanel(new BorderLayout());

        JPanel formPanel = super.getFormPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        //<editor-fold defaultstate="collapsed" desc="formPanel add">

        formPanel.add(theOutputIsTwoWayLabel);
        formPanel.add(theOutputIsTwoWay);
        formPanel.add(theOutputIsTwoWayValidate);
        theOutputIsTwoWayValidate.setForeground(Color.RED);


        formPanel.add(coolingCapacityBTUhLabel);
        formPanel.add(coolingCapacityBTUh);
        formPanel.add(coolingCapacityBTUhValidate);
        coolingCapacityBTUhValidate.setForeground(Color.RED);


        formPanel.add(coolingCapacityKwLabel);
        formPanel.add(coolingCapacityKw);
        formPanel.add(coolingCapacityKwValidate);
        coolingCapacityKwValidate.setForeground(Color.RED);


        formPanel.add(heatingCapacityBTUhLabel);
        formPanel.add(heatingCapacityBTUh);
        formPanel.add(heatingCapacityBTUhValidate);
        heatingCapacityBTUhValidate.setForeground(Color.RED);


        formPanel.add(ThreeRowCoilLabel);
        formPanel.add(ThreeRowCoil);
        formPanel.add(ThreeRowCoilValidate);
        ThreeRowCoilValidate.setForeground(Color.RED);
        //</editor-fold>

        JPanel submitPanel = new JPanel();
        submitPanel.add(submit);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(submitPanel, BorderLayout.SOUTH);

    }
    public void submitActionLister(ActionListener action){
        this.submit.addActionListener(action);
    }
    public JPanel getPanel(){
        return  this.panel;
    }



    public JTextField getTheOutputIsTwoWay() {
        return theOutputIsTwoWay;
    }

    public void setTheOutputIsTwoWay(JTextField theOutputIsTwoWay) {
        this.theOutputIsTwoWay = theOutputIsTwoWay;
    }

    public JTextField getCoolingCapacityBTUh() {
        return coolingCapacityBTUh;
    }

    public void setCoolingCapacityBTUh(JTextField coolingCapacityBTUh) {
        this.coolingCapacityBTUh = coolingCapacityBTUh;
    }

    public JTextField getCoolingCapacityKw() {
        return coolingCapacityKw;
    }

    public void setCoolingCapacityKw(JTextField coolingCapacityKw) {
        this.coolingCapacityKw = coolingCapacityKw;
    }

    public JTextField getHeatingCapacityBTUh() {
        return heatingCapacityBTUh;
    }

    public void setHeatingCapacityBTUh(JTextField heatingCapacityBTUh) {
        this.heatingCapacityBTUh = heatingCapacityBTUh;
    }

    public JTextField getThreeRowCoil() {
        return ThreeRowCoil;
    }

    public void setThreeRowCoil(JTextField threeRowCoil) {
        ThreeRowCoil = threeRowCoil;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setters labels validate">

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    public JButton getSubmit() {
        return submit;
    }



    public void setTheOutputIsTwoWayValidate(String theOutputIsTwoWayValidate) {
        this.theOutputIsTwoWayValidate.setText(theOutputIsTwoWayValidate);
    }

    public void setCoolingCapacityBTUhValidate(String coolingCapacityBTUhValidate) {
        this.coolingCapacityBTUhValidate.setText(coolingCapacityBTUhValidate);
    }

    public void setCoolingCapacityKwValidate(String coolingCapacityKwValidate) {
        this.coolingCapacityKwValidate.setText(coolingCapacityKwValidate);
    }

    public void setHeatingCapacityBTUhValidate(String heatingCapacityBTUhValidate) {
        this.heatingCapacityBTUhValidate.setText(heatingCapacityBTUhValidate);
    }

    public void setThreeRowCoilValidate(String threeRowCoilValidate) {
        ThreeRowCoilValidate.setText(threeRowCoilValidate);
    }
    public void setValuees(AirConditionerEntity airConditioner){
        super.setValuess(airConditioner);
        theOutputIsTwoWay.setText(airConditioner.getTheOutputIsTwoWay());
        coolingCapacityBTUh.setText(airConditioner.getCoolingCapacityBTUh());
        coolingCapacityKw.setText(airConditioner.getCoolingCapacityKw());
        heatingCapacityBTUh.setText(airConditioner.getHeatingCapacityBTUh());
        ThreeRowCoil.setText(airConditioner.getThreeRowCoil());
    }
    //</editor-fold>

}
