package org.example.Views.FanViews;

import org.example.Models.Entities.FanEntity;
import org.example.Models.Enumes.EnergyLables;
import org.example.Views.Components.SearchComponent;
import org.example.Views.CoolSystem.CoolSystemCreateView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreateEditFanView extends CoolSystemCreateView {
    private JPanel panel;
    public SearchComponent searchComponent = new SearchComponent();

    //<editor-fold defaultstate="collapsed" desc="Form">


    private JTextField length = new JTextField(10);
    private JLabel lengthLabel = new JLabel("Length");
    private JLabel lengthValidate = new JLabel("");

    private JTextField type = new JTextField(10);
    private JLabel typeLabel = new JLabel("Type");
    private JLabel typeValidate = new JLabel();

    private JCheckBox haveremoteController = new JCheckBox("Yes");
    private JLabel haveremoteControllerLabel = new JLabel("have remote Controller");
    private JLabel haveremoteControllerValidate = new JLabel();

    private JTextField dimension = new JTextField(10);
    private JLabel dimensionLabel = new JLabel("Dimention");
    private JLabel dimensionValidate = new JLabel();

    private JTextField windVolume = new JTextField(10);
    private JLabel windVolumeLabel = new JLabel("Wind volume");
    private JLabel windVolumeValidate = new JLabel();

    private JTextField lengthOfCable = new JTextField(10);
    private JLabel lengthOfCableLabel = new JLabel("Length of cable(meter)");
    private JLabel lengthOfCableValidate = new JLabel();


    private JButton submit = new JButton("Submit");
    //</editor-fold>

    public CreateEditFanView(){
        panel = new JPanel(new BorderLayout());


        JPanel formPanel = super.getFormPanel();
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(searchComponent.getPanel(), BorderLayout.NORTH);

        //<editor-fold defaultstate="collapsed" desc="formPanel">

        formPanel.add(lengthLabel);
        formPanel.add(length);
        formPanel.add(lengthValidate);
        lengthValidate.setForeground(Color.RED);

        formPanel.add(typeLabel);
        formPanel.add(type);
        formPanel.add(typeValidate);
        typeValidate.setForeground(Color.RED);

        formPanel.add(haveremoteControllerLabel);
        formPanel.add(haveremoteController);
        formPanel.add(haveremoteControllerValidate);
        haveremoteControllerValidate.setForeground(Color.RED);

        formPanel.add(dimensionLabel);
        formPanel.add(dimension);
        formPanel.add(dimensionValidate);
        dimensionValidate.setForeground(Color.RED);

        formPanel.add(windVolumeLabel);
        formPanel.add(windVolume);
        formPanel.add(windVolumeValidate);
        windVolumeValidate.setForeground(Color.RED);

        formPanel.add(lengthOfCableLabel);
        formPanel.add(lengthOfCable);
        formPanel.add(lengthOfCableValidate);
        lengthOfCableValidate.setForeground(Color.RED);
        //</editor-fold>

        JPanel submitPanel = new JPanel();
        submitPanel.add(submit);
        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(submitPanel, BorderLayout.SOUTH);

    }
    public void setValuess(FanEntity fan){
        super.setValuess(fan);
        length.setText(Integer.toString(fan.getLength()));
        type.setText(fan.getType());
        haveremoteController.setSelected(fan.isHaveremoteController());
        dimension.setText(fan.getDimension());
        windVolume.setText(fan.getWindVolume());
        lengthOfCable.setText(Integer.toString(fan.getLengthOfCable()));
    }
    public JPanel getPanel(){
        return panel;
    }

    public JButton getSubmit() {
        return submit;
    }
    public void addActionListener(ActionListener actionListener){
        this.submit.addActionListener(actionListener);
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }

    //<editor-fold defaultstate="collapsed" desc="inputs getter setter">

    public JTextField getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length.setText(Integer.toString(length));
    }

    public JTextField getType() {
        return type;
    }

    public void setType(String type) {
        this.type.setText(type);
    }

    public JCheckBox getHaveremoteController() {
        return haveremoteController;
    }

    public void setHaveremoteController(boolean haveremoteController) {
        this.haveremoteController.setSelected(haveremoteController);
    }

    public JTextField getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension.setText(dimension);
    }

    public JTextField getWindVolume() {
        return windVolume;
    }

    public void setWindVolume(String windVolume) {
        this.windVolume.setText(windVolume);
    }

    public JTextField getLengthOfCable() {
        return lengthOfCable;
    }

    public void setLengthOfCable(String lengthOfCable) {
        this.lengthOfCable.setText(lengthOfCable);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="inputs getter setter">

    public JLabel getLengthValidate() {
        return lengthValidate;
    }

    public void setLengthValidate(String lengthValidate) {
        this.lengthValidate.setText(lengthValidate);
    }

    public JLabel getTypeValidate() {
        return typeValidate;
    }

    public void setTypeValidate(String typeValidate) {
        this.typeValidate.setText(typeValidate);
    }

    public JLabel getHaveremoteControllerValidate() {
        return haveremoteControllerValidate;
    }

    public void setHaveremoteControllerValidate(String  haveremoteControllerValidate) {
        this.haveremoteControllerValidate.setText(haveremoteControllerValidate);
    }

    public JLabel getDimensionValidate() {
        return dimensionValidate;
    }

    public void setDimensionValidate(String dimensionValidate) {
        this.dimensionValidate.setText(dimensionValidate);
    }

    public JLabel getWindVolumeValidate() {
        return windVolumeValidate;
    }

    public void setWindVolumeValidate(String windVolumeValidate) {
        this.windVolumeValidate.setText(windVolumeValidate);
    }

    public JLabel getLengthOfCableValidate() {
        return lengthOfCableValidate;
    }

    public void setLengthOfCableValidate(String lengthOfCableValidate) {
        this.lengthOfCableValidate.setText(lengthOfCableValidate);
    }
    //</editor-fold>


}
