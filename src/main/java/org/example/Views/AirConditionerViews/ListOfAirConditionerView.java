package org.example.Views.AirConditionerViews;

import org.example.Models.Behavior.AirConditionerBehavior;
import org.example.Models.Entities.AirConditionerEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ListOfAirConditionerView {
    JPanel panel;
    AirConditionerTableModel tableModel;
    ArrayList<AirConditionerEntity> airConditionerEntities = null;
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JTable table;
    public ListOfAirConditionerView(){
        panel = new JPanel(new BorderLayout());
        try {
             airConditionerEntities = AirConditionerBehavior.singelton().getAirConditioneres();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tableModel = new AirConditionerTableModel(airConditionerEntities);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.add(delete);
        buttonsPanel.add(edit);
        panel.add(buttonsPanel, BorderLayout.SOUTH);
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
      this.panel = panel;
      this.panel.revalidate();
      this.panel.repaint();

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
