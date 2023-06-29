package org.example.Views.WaterCoolViews;

import org.example.Configure.UserConfigure;
import org.example.Models.Entities.FanEntity;
import org.example.Models.Entities.WaterCoolerEntity;
import org.example.Rules.RulesUser;
import org.example.Views.FanViews.ListFanTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListWaterCoolView {
    JPanel panel;
    WaterCoolerTableModel fanTableModel = null;
    ArrayList<WaterCoolerEntity> waterCooleres = null;
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JButton buy = new JButton("Buy");

    JTable table;
    public ListWaterCoolView(ArrayList<WaterCoolerEntity> waterCooleres){
        panel = new JPanel(new BorderLayout());
        this.waterCooleres = waterCooleres;
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
    }

    public JTable getTable() {
        return table;
    }
}
