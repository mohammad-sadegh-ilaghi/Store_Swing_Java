package org.example.Views.AirConditionerViews;

import org.example.Configure.UserConfigure;
import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Entities.AirConditionerEntity;
import org.example.Rules.RulesUser;
import org.example.Views.Components.SearchComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ListOfAirConditionerView {
    JPanel panel;

    public SearchComponent searchComponent = new SearchComponent();
    AirConditionerTableModel tableModel;
    ArrayList<AirConditionerEntity> airConditionerEntities = null;
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JButton buy = new JButton("Buy");

    JTable table;
    public ListOfAirConditionerView(ArrayList<AirConditionerEntity> airConditionerEntities){
        panel = new JPanel(new BorderLayout());
        this.airConditionerEntities = airConditionerEntities;
        tableModel = new AirConditionerTableModel(airConditionerEntities);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        panel.add(searchComponent.getPanel(), BorderLayout.NORTH);
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        if (UserConfigure.singlton().getUser().getUserRule().equals(RulesUser.ADMIN)){
            buttonsPanel.add(delete);
            buttonsPanel.add(edit);
            panel.add(buttonsPanel, BorderLayout.SOUTH);
        }
        else {
            panel.add(buy, BorderLayout.SOUTH);
        }
    }
    public void setBuyActionListener(ActionListener actionListener){
        buy.addActionListener(actionListener);
    }

    public JButton getBuy() {
        return buy;
    }

    public void setBuy(JButton buy) {
        this.buy = buy;
    }

    public void setEditActionListerer(ActionListener actionListener){
        this.edit.addActionListener(actionListener);
    }
    public void setDeleteActionListerer(ActionListener actionListener){
        this.delete.addActionListener(actionListener);
    }
    public JPanel getPanel(){
        return panel;
    }
    public void setPanel(JPanel panel){
      this.panel.removeAll();
      this.panel = panel;
      this.panel.revalidate();
      this.panel.repaint();

    }

    public ArrayList<AirConditionerEntity> getAirConditionerEntities() {
        return airConditionerEntities;
    }

    public void setAirConditionerEntities(ArrayList<AirConditionerEntity> airConditionerEntities) {
        this.airConditionerEntities = airConditionerEntities;

    }  public void repaint(){
        panel.revalidate();
        panel.repaint();
    }

    public AirConditionerTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(AirConditionerTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
