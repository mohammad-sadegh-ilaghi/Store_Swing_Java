package org.example.Views.WaterCoolViews;

import org.example.Configure.UserConfigure;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Rules.RulesUser;
import org.example.Views.Components.SearchComponent;
import org.example.Views.FanViews.ListFanTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListWaterCoolView {
    JPanel panel;
    public SearchComponent searchComponent;

    WaterCoolerTableModel fanTableModel = null;
    ArrayList<WaterCoolerEntity> waterCooleres = null;
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JButton buy = new JButton("Buy");

    JTable table;
    public ListWaterCoolView(ArrayList<WaterCoolerEntity> waterCooleres){
        searchComponent = new SearchComponent();
        panel = new JPanel(new BorderLayout());
        this.waterCooleres = waterCooleres;
        panel.add(searchComponent.getPanel(), BorderLayout.NORTH);

        fanTableModel = new WaterCoolerTableModel(this.waterCooleres);
        table = new JTable(fanTableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
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

    public ArrayList<WaterCoolerEntity> getWaterCooleres() {
        return waterCooleres;
    }

    public void setWaterCooleres(ArrayList<WaterCoolerEntity> waterCooleres) {
        this.waterCooleres = waterCooleres;
    }

    public void setBuyActionListener(ActionListener actionListener){
        buy.addActionListener(actionListener);
    }
    public void editActionListener(ActionListener edit) {
        this.edit.addActionListener(edit);
    }

    public void deleteActionListener(ActionListener delete) {
        this.delete.addActionListener(delete);
    }

    public JPanel getPanel(){
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
        this.panel.revalidate();
        this.panel.revalidate();
    }
    public void repaint(){
        panel.revalidate();
        panel.repaint();
    }
    public JTable getTable() {
        return table;
    }
}
