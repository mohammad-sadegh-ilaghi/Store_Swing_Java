package org.example.Views.CoolSystem;

import org.example.Models.Entities.CoolSystemEntity;
import org.example.Models.Enumes.EnergyLables;

import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;
import java.time.ZoneId;
import java.util.Date;

public class CoolSystemCreateView {
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
    JLabel id = new JLabel("");
    JPanel formPanel;
    public CoolSystemCreateView(){
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

        formPanel = new JPanel(new GridLayout(15,3));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel id = new JLabel("");

        //</editor-fold>
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
        //</editor-fold>
    }

    public JPanel getFormPanel() {
        return formPanel;
    }

    public void setFormPanel(JPanel formPanel) {
        this.formPanel = formPanel;
    }
//<editor-fold defaultstate="collapsed" desc="getter and setters Inputs">

    public JLabel getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id.setText(id.toString());
    }

    public JTextField getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand.setText(brand);
    }

    public JSpinner getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate.setValue(createdDate);
    }

    public JTextField getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made.setText(made);
    }

    public JTextField getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers.setText(Integer.toString(numbers));
    }
    public void setPower(String power){
        this.power.setText(power);
    }
    public JTextField getPower() {
        return power;
    }


    public JCheckBox getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew.setSelected(isNew);
    }

    public JSpinner getWarranty() {
        return warranty;
    }

    public void setWarranty(Date warranty) {
        this.warranty.setValue(warranty);
    }

    public JComboBox<String> getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(String energyLabel) {
        this.energyLabel.setSelectedItem(energyLabel);
    }

    public JTextField getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.setText(weight);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="setters labels validate">


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
    //</editor-fold>
    public void setValuess(CoolSystemEntity coolSystem){
        brand.setText(coolSystem.getBrand());
        createdDate.setValue(Date.from(coolSystem.getDateOfCreated().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        made.setText(coolSystem.getMade());
        numbers.setText(Integer.toString(coolSystem.getNumbers()));
        power.setText(coolSystem.getPower());
        isNew.setSelected(coolSystem.isNew());
        warranty.setValue(Date.from(coolSystem.getWarranty().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        energyLabel.setSelectedItem(coolSystem.getEnergyLabel());
        weight.setText(coolSystem.getWeight());
        id.setText(coolSystem.getId().toString());
    }

}
