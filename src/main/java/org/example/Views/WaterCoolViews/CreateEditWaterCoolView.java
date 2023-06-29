package org.example.Views.WaterCoolViews;

import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Views.CoolSystem.CoolSystemCreateView;
import org.example.Views.FanViews.CreateEditFanView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateEditWaterCoolView extends CoolSystemCreateView {
    JPanel panel;
    JTextField bodyMaterial = new JTextField(10);
    JLabel bodyMaterialLabel = new JLabel("Material Body ");
    JLabel bodyMaterialValidate = new JLabel();

    JTextField dimention = new JTextField(10);
    JLabel dimentionLabel = new JLabel("dimention");
    JLabel dimentionValidate = new JLabel();

    JTextField maximumWindPower = new JTextField(10);
    JLabel maximumWindPowerLabel = new JLabel("Maximum Wind Power");
    JLabel maximumWindPowerValidate = new JLabel();

    JTextField PumpPower = new JTextField(10);
    JLabel PumpPowerLabel= new JLabel("Pump Power");
    JLabel PumpPowerValidate = new JLabel();

    JTextField comsumptionWaterPeerHours = new JTextField(10);
    JLabel comsumptionWaterPeerHoursLabel = new JLabel("Comsumption Water Peer Hours");
    JLabel comsumptionWaterPeerHoursValidate = new JLabel();

    JCheckBox remoteController = new JCheckBox("Yes");
    JLabel remoteControllerLabel = new JLabel("Remote Controller");

    JButton submit = new JButton("Submit");
    public CreateEditWaterCoolView(){
        panel = new JPanel(new BorderLayout());
        JPanel formPanel = super.getFormPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(bodyMaterialLabel);
        formPanel.add(bodyMaterial);
        formPanel.add(bodyMaterialValidate);
        bodyMaterialValidate.setForeground(Color.RED);

        formPanel.add(dimentionLabel);
        formPanel.add(dimention);
        formPanel.add(dimentionValidate);
        dimentionValidate.setForeground(Color.RED);

        formPanel.add(maximumWindPowerLabel);
        formPanel.add(maximumWindPower);
        formPanel.add(maximumWindPowerValidate);
        maximumWindPowerValidate.setForeground(Color.RED);

        formPanel.add(PumpPowerLabel);
        formPanel.add(PumpPower);
        formPanel.add(PumpPowerValidate);
        PumpPowerValidate.setForeground(Color.RED);

        formPanel.add(comsumptionWaterPeerHoursLabel);
        formPanel.add(comsumptionWaterPeerHours);
        formPanel.add(comsumptionWaterPeerHoursValidate);
        comsumptionWaterPeerHoursValidate.setForeground(Color.RED);

        formPanel.add(remoteControllerLabel);
        formPanel.add(remoteController);

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(submit, BorderLayout.SOUTH);
    }

    public void setValuess(WaterCoolerEntity waterCooler){
        super.setValuess(waterCooler);
        bodyMaterial.setText(waterCooler.getBodyMaterial());
        dimention.setText(waterCooler.getDimention());
        maximumWindPower.setText(waterCooler.getMaximumWindPower());
        PumpPower.setText(waterCooler.getPumpPower());
        comsumptionWaterPeerHours.setText(waterCooler.getComsumptionWaterPeerHours());
        remoteController.setSelected(waterCooler.getRemoteController());
    }
    public JPanel getPanel(){
        return panel;
    }
    public void addActionListenerSubmit(ActionListener actionListener){
        submit.addActionListener(actionListener);
    }

    public JTextField getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(JTextField bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public JLabel getBodyMaterialValidate() {
        return bodyMaterialValidate;
    }

    public void setBodyMaterialValidate(String bodyMaterialValidate) {
        this.bodyMaterialValidate.setText(bodyMaterialValidate);
    }

    public JTextField getDimention() {
        return dimention;
    }

    public void setDimention(JTextField dimention) {
        this.dimention = dimention;
    }

    public JLabel getDimentionValidate() {
        return dimentionValidate;
    }

    public void setDimentionValidate(String dimentionValidate) {
        this.dimentionValidate.setText(dimentionValidate);
    }

    public JTextField getMaximumWindPower() {
        return maximumWindPower;
    }

    public void setMaximumWindPower(JTextField maximumWindPower) {
        this.maximumWindPower = maximumWindPower;
    }

    public JLabel getMaximumWindPowerValidate() {
        return maximumWindPowerValidate;
    }

    public void setMaximumWindPowerValidate(String maximumWindPowerValidate) {
        this.maximumWindPowerValidate.setText(maximumWindPowerValidate);
    }

    public JTextField getPumpPower() {
        return PumpPower;
    }

    public void setPumpPower(JTextField pumpPower) {
        PumpPower = pumpPower;
    }

    public JLabel getPumpPowerValidate() {
        return PumpPowerValidate;
    }

    public void setPumpPowerValidate(String pumpPowerValidate) {
        PumpPowerValidate.setText(pumpPowerValidate);
    }

    public JTextField getComsumptionWaterPeerHours() {
        return comsumptionWaterPeerHours;
    }

    public void setComsumptionWaterPeerHours(JTextField comsumptionWaterPeerHours) {
        this.comsumptionWaterPeerHours = comsumptionWaterPeerHours;
    }

    public JLabel getComsumptionWaterPeerHoursValidate() {
        return comsumptionWaterPeerHoursValidate;
    }

    public void setComsumptionWaterPeerHoursValidate(String comsumptionWaterPeerHoursValidate) {
        this.comsumptionWaterPeerHoursValidate.setText(comsumptionWaterPeerHoursValidate);
    }

    public JCheckBox getRemoteController() {
        return remoteController;
    }

    public void setRemoteController(JCheckBox remoteController) {
        this.remoteController = remoteController;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }
}
