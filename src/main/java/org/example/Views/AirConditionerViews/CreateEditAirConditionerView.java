package org.example.Views.AirConditionerViews;

import org.example.Models.Entities.AirConditionerEntity;
import org.example.Models.Enumes.EnergyLables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.ZoneId;
import java.util.Date;

public class CreateEditAirConditionerView {
    JPanel panel;

    //<editor-fold defaultstate="collapsed" desc="Form">

    JTextField brand = new JTextField(10);
    JLabel brandLabel = new JLabel("Brand");
    JLabel brandValidate = new JLabel("");

    JSpinner createdDate;
    JLabel createdDateLabel = new JLabel("Created date");
    JLabel createdDateValidate = new JLabel("");


    JTextField made = new JTextField(10);
    JLabel madeLabel = new JLabel("Made");
    JLabel madeValidate = new JLabel("");


    JTextField numbers = new JTextField(10);
    JLabel numbersLabel = new JLabel("Numbers");
    JLabel numbersValidate = new JLabel("");

    JTextField power = new JTextField(10);
    JLabel powerLabel = new JLabel("Power");
    JLabel powerValidate = new JLabel("");

    JCheckBox isNew = new JCheckBox("Yes");
    JLabel isNewLabel = new JLabel("Is New");

    JSpinner warranty;
    JLabel warrantyLabel = new JLabel("Warranty");
    JLabel warrantyValidate = new JLabel("");

    JComboBox<String> energyLabel;
    JLabel energyLabelLabel = new JLabel("Energy Label");
    JLabel energyLabelValidate = new JLabel("");

    JTextField weight = new JTextField(10);
    JLabel weightLabel = new JLabel("Weight");
    JLabel weightValidate = new JLabel("");

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

    JLabel id = new JLabel("");


    JButton submit = new JButton("Submit");
    //</editor-fold>


    public CreateEditAirConditionerView(){
        panel = new JPanel(new BorderLayout());



        //<editor-fold defaultstate="collapsed" desc="Setup Date Editor and selector tag">

        SpinnerDateModel createDateModel = new SpinnerDateModel();
        createdDate = new JSpinner(createDateModel);
        JSpinner.DateEditor createdDateeditor = new JSpinner.DateEditor(createdDate, "yyyy-MM-dd");
        createdDate.setEditor(createdDateeditor);

        SpinnerDateModel warrantyModel = new SpinnerDateModel();
        warranty = new JSpinner(warrantyModel);
        JSpinner.DateEditor warrantyEditor = new JSpinner.DateEditor(warranty, "yyyy-MM-dd");
        warranty.setEditor(warrantyEditor);

        EnergyLables[] energiesLabel = EnergyLables.values();
        String[] StringEnergyLabels = new String[energiesLabel.length];
        for (int i = 0; i < energiesLabel.length; i++) {
            StringEnergyLabels[i] = energiesLabel[i].getStringValue();
        }
        energyLabel = new JComboBox<>(StringEnergyLabels);


        //</editor-fold>

        JPanel formPanel = new JPanel(new GridLayout(15,3));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //<editor-fold defaultstate="collapsed" desc="formPanel">

        formPanel.add(brandLabel);
        formPanel.add(brand);
        formPanel.add(brandValidate);
        brandValidate.setForeground(Color.RED);

        formPanel.add(madeLabel);
        formPanel.add(made);
        formPanel.add(madeValidate);
        madeValidate.setForeground(Color.RED);

        formPanel.add(isNewLabel);
        formPanel.add(isNew);
        formPanel.add(new JLabel());

        formPanel.add(numbersLabel);
        formPanel.add(numbers);
        formPanel.add(numbersValidate);
        numbersValidate.setForeground(Color.RED);

        formPanel.add(createdDateLabel);
        formPanel.add(createdDate);
        formPanel.add(createdDateValidate);
        createdDateValidate.setForeground(Color.RED);

        formPanel.add(warrantyLabel);
        formPanel.add(warranty);
        formPanel.add(warrantyValidate);
        warrantyValidate.setForeground(Color.RED);


        formPanel.add(powerLabel);
        formPanel.add(power);
        formPanel.add(powerValidate);
        powerValidate.setForeground(Color.RED);


        formPanel.add(energyLabelLabel);
        formPanel.add(energyLabel);
        formPanel.add(energyLabelValidate);
        energyLabelValidate.setForeground(Color.RED);

        formPanel.add(weightLabel);
        formPanel.add(weight);
        formPanel.add(weightValidate);
        weightValidate.setForeground(Color.RED);

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

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(submit, BorderLayout.SOUTH);

    }
    public void submitActionLister(ActionListener action){
        this.submit.addActionListener(action);
    }
    public JPanel getPanel(){
        return  this.panel;
    }

    //<editor-fold defaultstate="collapsed" desc="getter and setters Inputs">

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JTextField getBrand() {
        return brand;
    }

    public void setBrand(JTextField brand) {
        this.brand = brand;
    }

    public JSpinner getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(JSpinner createdDate) {
        this.createdDate = createdDate;
    }

    public JTextField getMade() {
        return made;
    }

    public void setMade(JTextField made) {
        this.made = made;
    }

    public JTextField getNumbers() {
        return numbers;
    }

    public void setNumbers(JTextField numbers) {
        this.numbers = numbers;
    }

    public JTextField getPower() {
        return power;
    }

    public void setPower(JTextField power) {
        this.power = power;
    }

    public JCheckBox getIsNew() {
        return isNew;
    }

    public void setIsNew(JCheckBox isNew) {
        this.isNew = isNew;
    }

    public JSpinner getWarranty() {
        return warranty;
    }

    public void setWarranty(JSpinner warranty) {
        this.warranty = warranty;
    }

    public JComboBox<String> getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(JComboBox<String> energyLabel) {
        this.energyLabel = energyLabel;
    }

    public JTextField getWeight() {
        return weight;
    }

    public void setWeight(JTextField weight) {
        this.weight = weight;
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

    public void setBrandValidate(String brandValidate) {
        this.brandValidate.setText( brandValidate);
    }

    public void setCreatedDateValidate(String createdDateValidate) {
        this.createdDateValidate.setText(createdDateValidate);
    }

    public void setMadeValidate(String madeValidate) {
        this.madeValidate.setText(madeValidate);
    }

    public void setNumbersValidate(String numbersValidate) {
        this.numbersValidate.setText(numbersValidate);
    }

    public void setPowerValidate(String powerValidate) {
        this.powerValidate.setText(powerValidate);
    }

    public void setWarrantyValidate(String warrantyValidate) {
        this.warrantyValidate.setText(warrantyValidate);
    }

    public void setEnergyLabelValidate(String energyLabelValidate) {
        this.energyLabelValidate.setText(energyLabelValidate);
    }

    public void setWeightValidate(String weightValidate) {
        this.weightValidate.setText(weightValidate);
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
        brand.setText(airConditioner.getBrand());
        createdDate.setValue(Date.from(airConditioner.getDateOfCreated().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        made.setText(airConditioner.getMade());
        numbers.setText(Integer.toString(airConditioner.getNumbers()));
        power.setText(airConditioner.getPower());
        isNew.setSelected(airConditioner.isNew());
        warranty.setValue(Date.from(airConditioner.getWarranty().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        energyLabel.setSelectedItem(airConditioner.getEnergyLabel());
        weight.setText(airConditioner.getWeight());
        theOutputIsTwoWay.setText(airConditioner.getTheOutputIsTwoWay());
        coolingCapacityBTUh.setText(airConditioner.getCoolingCapacityBTUh());
        coolingCapacityKw.setText(airConditioner.getCoolingCapacityKw());
        heatingCapacityBTUh.setText(airConditioner.getHeatingCapacityBTUh());
        ThreeRowCoil.setText(airConditioner.getThreeRowCoil());
        id.setText(airConditioner.getId().toString());
    }
    //</editor-fold>

}
